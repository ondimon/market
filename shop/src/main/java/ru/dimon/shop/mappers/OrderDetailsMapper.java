package ru.dimon.shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dimon.shop.dto.OrderDetailsDto;
import ru.dimon.shop.entities.OrderDetails;

@Mapper
public interface OrderDetailsMapper {
    OrderDetailsMapper MAPPER = Mappers.getMapper(OrderDetailsMapper.class);
    OrderDetailsDto formOrderDetails(OrderDetails orderDetails);
}
