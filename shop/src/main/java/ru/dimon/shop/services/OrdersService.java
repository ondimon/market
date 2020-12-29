package ru.dimon.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dimon.shop.config.OrderIntegrationConfig;
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
    private final OrderIntegrationConfig orderIntegrationConfig;
    @Autowired
    public OrdersService(OrdersRepository ordersRepository, OrderIntegrationConfig orderIntegrationConfig) {
        this.ordersRepository = ordersRepository;
        this.orderIntegrationConfig = orderIntegrationConfig;
    }

    public List<Order> findAll() {
        return ordersRepository.findAll();
    }

    public List<OrderDto> findAllDto() {
       return ordersRepository.findAll().stream()
                        .map(order -> mapper.fromOrder(order))
                        .collect(Collectors.toList());
    }

    @Transactional
    public void saveOrder(Order order) {
        ordersRepository.save(order);
        sendOrder(order);
    }

    private void sendOrder(Order order) {
        OrderDto orderDto = mapper.fromOrder(order);
        Message<OrderDto> message = MessageBuilder.withPayload(orderDto)
                .setHeader("Content-type", "application/json")
                .build();
        orderIntegrationConfig.getOrdersChannel().send(message);
    }

}
