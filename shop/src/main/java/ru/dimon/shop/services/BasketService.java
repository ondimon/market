package ru.dimon.shop.services;

import org.springframework.stereotype.Service;
import ru.dimon.shop.dto.BasketDto;
import ru.dimon.shop.dto.ProductDto;
import ru.dimon.shop.entities.*;
import ru.dimon.shop.mappers.ProductMapper;
import ru.dimon.shop.repositories.BasketRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final BasketRepository  basketRepository;
    private final UsersService usersService;
    private final ProductsService productsService;
    private final OrdersService ordersService;

    public BasketService(BasketRepository basketRepository, UsersService usersService, ProductsService productsService, OrdersService ordersService) {
        this.basketRepository = basketRepository;
        this.usersService = usersService;
        this.productsService = productsService;
        this.ordersService = ordersService;
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

    public void createOrder(String username) {
        User user = usersService.findByUsername(username);
        if(user == null){
            throw new RuntimeException("User is not found");
        }
        Basket basket = user.getBasket();
        if(basket == null || basket.getProducts().isEmpty()){
            return;
        }

        Order order = new Order();
        order.setStatus(OrderStatus.NEW);
        order.setUser(user);

        Map<Product, Long> productWithAmount = basket.getProducts().stream()
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));

        List<OrderDetails> orderDetails = productWithAmount.entrySet().stream()
                .map(pair -> new OrderDetails(order, pair.getKey(), pair.getValue()))
                .collect(Collectors.toList());

        BigDecimal total = new BigDecimal(orderDetails.stream()
                .map(detail -> detail.getPrice().multiply(detail.getAmount()))
                .mapToDouble(BigDecimal::doubleValue).sum());

        order.setDetails(orderDetails);
        order.setSum(total);
        order.setAddress("none");

        ordersService.saveOrder(order);
        basket.getProducts().clear();
        basketRepository.save(basket);
    }
    private List<Product> getCollectRefProductsByIds(List<Long> productIds) {
        return productIds.stream()
                .map(productsService::findById)
                .collect(Collectors.toList());
    }



}
