package ru.dimon.shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.dimon.shop.dto.OrderDto;
import ru.dimon.shop.entities.Order;


@Mapper(uses = { OrderDetailsMapper.class })
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "details", target = "detailsDto")
    OrderDto fromOrder(Order order);
}
