package ru.dimon.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dimon.market.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
}
