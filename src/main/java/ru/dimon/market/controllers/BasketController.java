package ru.dimon.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dimon.market.dto.BasketDto;
import ru.dimon.market.services.BasketService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping({"","/"})
    public String basketInfo(Model model, Principal principal) {
        BasketDto basket;
        if (principal == null) {
            basket = new BasketDto();
        } else {
            basket = basketService.getBasketByUser(principal.getName());
        }
        model.addAttribute("basket", basket);
        return "basket";
    }

    @GetMapping("/add/{id}")
    public String addProduct(@PathVariable Long id, Principal principal, HttpSession session) {
        if(principal == null){
            return "redirect:/products";
        }
        basketService.addToUserBasket(id, principal.getName());
        BasketDto basketDto = basketService.getBasketByUser(principal.getName());
        session.setAttribute("basketAmountProducts", basketDto.getAmountProducts());
        session.setAttribute("basketTotalSum", basketDto.getTotalSum());
        return "redirect:/products";
    }

}
