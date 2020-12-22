package ru.dimon.market.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.dimon.market.dto.OrderDto;
import ru.dimon.market.entities.Order;


@Mapper(uses = { OrderDetailsMapper.class })
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "details", target = "detailsDto")
    OrderDto fromOrder(Order order);
}
