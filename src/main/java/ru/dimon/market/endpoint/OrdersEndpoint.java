package ru.dimon.market.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.dimon.market.dto.OrderDto;
import ru.dimon.market.services.OrdersService;
import ru.dimon.market.ws.orders.GetOrdersRequest;
import ru.dimon.market.ws.orders.GetOrdersResponse;
import ru.dimon.market.ws.orders.OrderWS;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

@Endpoint
public class OrdersEndpoint {

    public static final String NAMESPACE_URL = "http://dimon.ru/market/ws/orders";

    private final OrdersService ordersService;

    @Autowired
    public OrdersEndpoint(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getOrdersRequest")
    @ResponsePayload
    public GetOrdersResponse getOrders(@RequestPayload GetOrdersRequest request) {
        GetOrdersResponse getOrdersResponse = new GetOrdersResponse();
        ordersService.findAllDto().forEach(orderDto -> getOrdersResponse.getOrders().add(createOrderWS(orderDto)));
        return getOrdersResponse;
    }

    private OrderWS createOrderWS(OrderDto dto) {
        XMLGregorianCalendar created = null;
        try {
            created = DatatypeFactory.newInstance().newXMLGregorianCalendar(dto.getCreated().toString());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        OrderWS ws = new OrderWS();
        ws.setId(dto.getId());
        ws.setCreated(created);
        ws.setUsername(dto.getUser().getUsername());
        ws.setStatus(ru.dimon.market.ws.orders.OrderStatus.fromValue(dto.getStatus().toString()));
        ws.setAmountProducts(BigDecimal.valueOf(dto.getDetailsDto().size()));
        ws.setSum(dto.getSum().doubleValue());
        return ws;
    }

}
