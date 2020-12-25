package ru.dimon.shop.dto;

import lombok.Data;

@Data
public class BasketItemDto {
    private ProductDto product;
    private Double price;
    private Double amount;
    private Double sum;

    BasketItemDto(ProductDto product) {
        this.product = product;
        this.price = product.getPrice();
        this.amount = 1.0;
        calculateSum();
    }

    public void addProduct() {
        this.amount ++;
        calculateSum();
    }

    private void calculateSum() {
        sum = price * amount;
    }
}
