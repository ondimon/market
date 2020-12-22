package ru.dimon.market.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class LoggerRepositoryImpl<T> implements LoggerRepository<T>{
    private final List<T> loggerStorage = new ArrayList<>();

    @Override
    public void save(T log) {
        loggerStorage.add(log);
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(loggerStorage);
    }
}
