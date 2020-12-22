package ru.dimon.market.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepository<T> {
    void save(T log);
    List<T> getAll();
}
