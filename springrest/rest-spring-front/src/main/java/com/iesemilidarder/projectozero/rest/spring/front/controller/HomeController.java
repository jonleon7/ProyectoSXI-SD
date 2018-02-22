package com.iesemilidarder.projectozero.rest.spring.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.iesemilidarder.projectozero.core.base.ReadRestaurant;
import com.iesemilidarder.projectozero.core.dao.Restaurant;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("llego");
        ReadRestaurant rd = new ReadRestaurant();
        List<Restaurant> data = rd.readRestaurants("");
        model.addAttribute("restaurantes",data);
        return "index";
    }
}