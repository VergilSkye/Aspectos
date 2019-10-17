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
        EmployeeManager em = new EmployeeManager();
        em.getEmployeeById(1);
        return "Hello World!";
    }
    @RequestMapping("/log")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}