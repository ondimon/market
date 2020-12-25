package ru.dimon.shop.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class MethodCallLogger {
    private Date time;
    private String className;
    private String method;

}
