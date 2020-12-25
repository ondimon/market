package ru.dimon.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dimon.shop.services.MethodCallLoggerService;

@Controller
@RequestMapping("/logs")
@PreAuthorize("hasAuthority(T(ru.dimon.shop.entities.Role).ADMIN.name())")
public class LoggerMethodController {
    private final MethodCallLoggerService methodCallLoggerService;

    @Autowired
    public LoggerMethodController(MethodCallLoggerService methodCallLoggerService) {
        this.methodCallLoggerService = methodCallLoggerService;
    }

    @GetMapping("/method")
    String getMethodLogs(Model model) {
        model.addAttribute("logs", methodCallLoggerService.getAll());
        return "callmethodlog";
    }

}
