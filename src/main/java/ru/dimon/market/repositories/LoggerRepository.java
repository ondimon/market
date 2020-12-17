package ru.dimon.market.repositories;

import java.util.List;


public interface LoggerRepository<T> {
    void save(T log);
    List<T> getAll();
}
