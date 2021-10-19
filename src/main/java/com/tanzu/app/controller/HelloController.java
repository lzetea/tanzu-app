package com.tanzu.app.controller;

import com.tanzu.app.domain.Choice;
import com.tanzu.app.domain.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    private final AtomicInteger counter = new AtomicInteger();
    private final List<Hello> hellos = new ArrayList<>();

    public HelloController(){
        hellos.add(new Hello(new Choice("/images/cat.gif", "Cat"), new Choice("/images/dog.gif", "Dog")));
        hellos.add(new Hello(new Choice("/images/ski.gif", "Ski"), new Choice("/images/snowboard.gif", "Snowboard")));
        hellos.add(new Hello(new Choice("/images/beach.gif", "Beach"), new Choice("/images/mountain.gif", "Mountain")));
    }

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("hello", hellos.get(counter.getAndIncrement() % hellos.size()));
        return "hello";
    }
}
