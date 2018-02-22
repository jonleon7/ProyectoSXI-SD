package com.learningjava.rest.spring.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.iesemilidarder.projectozero.core.base.ReadRestaurant;
import com.iesemilidarder.projectozero.core.dao.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
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