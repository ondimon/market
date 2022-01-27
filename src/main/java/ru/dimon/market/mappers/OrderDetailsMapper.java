package ru.dimon.market.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dimon.market.dto.OrderDetailsDto;
import ru.dimon.market.entities.OrderDetails;

@Mapper
public interface OrderDetailsMapper {
    OrderDetailsMapper MAPPER = Mappers.getMapper(OrderDetailsMapper.class);
    OrderDetailsDto formOrderDetails(OrderDetails orderDetails);
}
