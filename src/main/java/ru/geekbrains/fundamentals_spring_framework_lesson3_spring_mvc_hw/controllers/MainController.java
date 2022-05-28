package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping
    public String showIndexPage(){
        return "index";
    }
}
