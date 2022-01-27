package ru.dimon.shop.services;

import org.springframework.stereotype.Service;
import ru.dimon.shop.dto.BasketDto;
import ru.dimon.shop.dto.ProductDto;
import ru.dimon.shop.entities.Basket;
import ru.dimon.shop.entities.Product;
import ru.dimon.shop.entities.User;
import ru.dimon.shop.mappers.ProductMapper;
import ru.dimon.shop.repositories.BasketRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final BasketRepository  basketRepository;
    private final UsersService usersService;
    private final ProductsService productsService;

    public BasketService(BasketRepository basketRepository, UsersService usersService, ProductsService productsService) {
        this.basketRepository = basketRepository;
        this.usersService = usersService;
        this.productsService = productsService;
    }

    public BasketDto getBasketByUser(String name) {
       User user = usersService.findByUsername(name);
       if(user == null || user.getBasket() == null){
            return new BasketDto();
       }

       Basket basket = user.getBasket();
       BasketDto basketDto = new BasketDto();
       List<Product> products = basket.getProducts();

       for (Product product : products) {
           ProductDto productDto = ProductMapper.MAPPER.fromProduct(product);
           basketDto.addProduct(productDto);
       }
       basketDto.aggregate();
       return basketDto;
    }

    @Transactional
    public void addToUserBasket(Long productId, String username) {
        User user = usersService.findByUsername(username);

        Basket basket = user.getBasket();
        if(basket == null){
            Basket newBasket = createBucket(user, Collections.singletonList(productId));
            user.setBasket(newBasket);
            usersService.saveOrUpdate(user);
        }
        else {
            addProducts(basket, Collections.singletonList(productId));
        }
    }

    @Transactional
    public void addProducts(Basket basket, List<Long> productIds) {
        List<Product> products = basket.getProducts();
        List<Product> newProductsList = products == null ? new ArrayList<>() : new ArrayList<>(products);
        newProductsList.addAll(getCollectRefProductsByIds(productIds));
        basket.setProducts(newProductsList);
        basketRepository.save(basket);
    }

    @Transactional
    public Basket createBucket(User user, List<Long> productIds) {
        Basket basket = new Basket();
        basket.setUser(user);
        List<Product> productList = getCollectRefProductsByIds(productIds);
        basket.setProducts(productList);
        return basketRepository.save(basket);
    }

    private List<Product> getCollectRefProductsByIds(List<Long> productIds) {
        return productIds.stream()
                .map(productsService::findById)
                .collect(Collectors.toList());
    }

}
