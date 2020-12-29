package ru.dimon.orderservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = {"id"})
public class ProductDto {
    private Long id;
    private  String Title;
    private Double price;
}
