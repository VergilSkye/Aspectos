package com.vergil.Aspect.controllers;

import com.vergil.Aspect.methods.EmployeeManager;
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
        EmployeeManager em = new EmployeeManager();
        em.getEmployeeById(1);
        return "Hello World!";
    }
}