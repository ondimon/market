package ru.dimon.orderservice.integration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.dimon.orderservice.dto.OrderDto;
import ru.dimon.orderservice.services.OrderService;


import java.util.Map;

@Component
public class OrderActivator {

    private final OrderService orderService;

    public OrderActivator(OrderService orderService) {
        this.orderService = orderService;
    }

    @ServiceActivator(inputChannel = "ordersChannel")
    public void listenNewsChannel(@Payload OrderDto payload, @Headers Map<String,Object> headers){
        System.out.println("Get order in message: " + payload);
        orderService.saveToFile(payload);
    }
}