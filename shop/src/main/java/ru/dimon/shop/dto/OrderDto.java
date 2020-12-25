package ru.dimon.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dimon.shop.entities.OrderStatus;
import ru.dimon.shop.entities.User;
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
    private User user;
    private BigDecimal sum;
    private String address;
    private List<OrderDetailsDto> detailsDto;
    private OrderStatus status;
}
