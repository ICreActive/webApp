package com.shkubel.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping()
    public String index (Model model) {
        // получаем все посты
        return null;
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        // получаем пост по id
        return null;
    }

}
