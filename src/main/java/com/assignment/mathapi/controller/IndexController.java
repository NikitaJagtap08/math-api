package com.assignment.mathapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/math-api")
    String getIndex()
    {
        return "Welcome to Math Api Web Service";
    }
}
