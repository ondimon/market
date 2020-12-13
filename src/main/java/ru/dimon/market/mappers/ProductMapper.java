package ru.dimon.market.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dimon.market.dto.ProductDto;
import ru.dimon.market.entities.Product;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    ProductDto fromProduct(Product product);
}
