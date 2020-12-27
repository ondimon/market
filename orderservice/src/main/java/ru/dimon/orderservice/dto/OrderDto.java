package ru.dimon.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime changed;
    private UserDto user;
    private BigDecimal sum;
    private String address;
    private List<OrderDetailsDto> detailsDto;
    private OrderStatus status;
}