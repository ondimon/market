package ru.dimon.market.dto;

import lombok.Data;
import ru.dimon.market.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasketDto {
    private final List<BasketItemDto> basketItems = new ArrayList<>();
    private int amountProducts;
    private double totalSum;

    public void addProduct(ProductDto product) {
        BasketItemDto basketItemDto = basketItems.stream()
                                        .filter(bi -> bi.getProduct().equals(product))
                                        .findFirst().orElse(null);
        if (basketItemDto == null) {
            basketItemDto  = new BasketItemDto(product);
            basketItems.add(basketItemDto);
        } else {
            basketItemDto.addProduct();
        }
    }

    public void aggregate(){
        this.amountProducts = basketItems.size();
        this.totalSum = basketItems.stream()
                .map(BasketItemDto::getSum)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

}
