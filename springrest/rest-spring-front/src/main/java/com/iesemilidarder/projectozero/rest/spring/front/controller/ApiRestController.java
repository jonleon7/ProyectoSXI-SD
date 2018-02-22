package com.iesemilidarder.projectozero.rest.spring.front.controller;

import com.iesemilidarder.projectozero.rest.spring.core.Greeting;
import com.iesemilidarder.projectozero.rest.spring.core.base.ReadRestaurant;
import com.iesemilidarder.projectozero.rest.spring.core.dao.Restaurant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(path = "/rest/api")
public class ApiRestController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/restaurantes",method = RequestMethod.GET)
    public List<Restaurant> listaRestaurants() {
        ReadRestaurant readRestaurant = new ReadRestaurant();
        return readRestaurant.readRestaurants("");
    }

}
