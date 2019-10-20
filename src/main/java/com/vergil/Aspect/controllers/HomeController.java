package com.vergil.Aspect.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    
    @RequestMapping("/")
    public List<String> file() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./logs/spring.log"));
        return lines;
    }
    
}