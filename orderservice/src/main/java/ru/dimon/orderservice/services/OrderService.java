package ru.dimon.orderservice.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;
import ru.dimon.orderservice.dto.OrderDto;

@Service
public class OrderService {

    public void saveToFile(OrderDto order) {
        File orderFolder = new File("./data/orders");

        File orderFile = new File(orderFolder, order.getId() + ".json");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(orderFile, order);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
