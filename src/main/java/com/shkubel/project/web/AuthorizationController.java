package com.shkubel.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthorizationController {


    @GetMapping("/")
    public String home() {
        return "static/index";
    }

}
