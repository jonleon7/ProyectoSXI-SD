package com.iesemilidarder.projectozero.rest.spring.front.controller;

import com.iesemilidarder.projectozero.rest.spring.core.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(path = "/")
public class ApiRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting",method = RequestMethod.GET)
    public Greeting greeting
            (@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public List<Greeting> list() {
        List<Greeting> arrData = new ArrayList<>();
        for (int i=0;i<9;i++){
            arrData.add(new Greeting(counter.incrementAndGet(),
                    String.format(template, i)));
        }
        return arrData;
    }

}
