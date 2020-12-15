package ru.dimon.market.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"id"})
public class ProductDto {
    @NotNull
    private Long id;
    private  String Title;
    private Double price;
}
