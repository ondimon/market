package ru.dimon.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dimon.market.entities.Order;
import ru.dimon.market.entities.Product;

import javax.persistence.*;
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
