package ru.dimon.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dimon.shop.entities.Product;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDto {
    private Product product;
    private BigDecimal amount;
    private BigDecimal price;
}
