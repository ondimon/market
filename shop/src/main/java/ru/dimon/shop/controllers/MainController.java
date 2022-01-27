package ru.dimon.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dimon.shop.services.UsersService;

import java.security.Principal;

@Controller
public class MainController {
    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/userinfo")
    public String getUserInfo(Model model, Principal principal) {
        model.addAttribute("user", usersService.findByUsernameDto(principal.getName()));
        return "user_info";
    }
}
