package ru.dimon.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.dimon.market.repositories.LoggerRepository;
import ru.dimon.market.utils.MethodCallLogger;

import java.util.List;

@Service
public class MethodCallLoggerService {
    private LoggerRepository<MethodCallLogger> loggerRepository;

    @Autowired
    public void setLoggerRepository(LoggerRepository<MethodCallLogger> loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    public List<MethodCallLogger> getAll() {
        return loggerRepository.getAll();
    }

    public void save(MethodCallLogger logger) {
        loggerRepository.save(logger);
    }

}
