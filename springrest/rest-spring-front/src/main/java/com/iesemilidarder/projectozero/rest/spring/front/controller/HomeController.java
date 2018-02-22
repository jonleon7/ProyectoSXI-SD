package com.iesemilidarder.projectozero.rest.spring.front.controller;

import com.iesemilidarder.projectozero.rest.spring.core.base.ReadRestaurant;
import com.iesemilidarder.projectozero.rest.spring.core.dao.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("Cargando de datos completado");
        return "index";
    }

    @RequestMapping(value = "/restaurantes", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        ReadRestaurant readRestaurant = new ReadRestaurant();
        List<Restaurant> data = readRestaurant.readRestaurants("");
        model.addAttribute("restaurantes", data);
        return "restaurantes";
    }
}