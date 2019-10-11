package com.vergil.Aspect.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(){
        log.debug("ENtrou nessa porra");
        return "Hello World!";
    }
}