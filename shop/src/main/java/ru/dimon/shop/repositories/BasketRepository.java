package ru.dimon.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dimon.shop.entities.Basket;

@Repository
public interface BasketRepository  extends JpaRepository<Basket, Long> {
}
