package ru.dimon.shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dimon.shop.dto.ProductDto;
import ru.dimon.shop.entities.Product;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    ProductDto fromProduct(Product product);
}
