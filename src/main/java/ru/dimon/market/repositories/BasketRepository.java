package ru.dimon.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dimon.market.entities.Basket;

@Repository
public interface BasketRepository  extends JpaRepository<Basket, Long> {
}
