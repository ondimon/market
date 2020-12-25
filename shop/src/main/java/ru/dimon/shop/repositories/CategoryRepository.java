package ru.dimon.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dimon.shop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
