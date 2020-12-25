package ru.dimon.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dimon.shop.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
}
