package ru.dimon.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dimon.market.dto.OrderDto;
import ru.dimon.market.entities.Order;
import ru.dimon.market.mappers.OrderMapper;
import ru.dimon.market.repositories.OrdersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderMapper mapper = OrderMapper.MAPPER;
    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Order> findAll() {
        return ordersRepository.findAll();
    }

    public List<OrderDto> findAllDto() {
       return ordersRepository.findAll().stream()
                        .map(order -> mapper.fromOrder(order))
                        .collect(Collectors.toList());
    }
}
