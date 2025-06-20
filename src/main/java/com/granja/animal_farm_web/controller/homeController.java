package com.granja.animal_farm_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class homeController {

    @GetMapping("/animals")
    public String index(){
        return "index";
    }
}
