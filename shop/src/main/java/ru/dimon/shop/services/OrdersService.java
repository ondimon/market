package ru.dimon.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dimon.shop.dto.OrderDto;
import ru.dimon.shop.entities.Order;
import ru.dimon.shop.mappers.OrderMapper;
import ru.dimon.shop.repositories.OrdersRepository;

import java.io.File;
import java.io.IOException;
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
