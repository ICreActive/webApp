package com.shkubel.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaviController {

    @GetMapping("/home")
    public String homePage (){
        return "static/home";
    }
}
