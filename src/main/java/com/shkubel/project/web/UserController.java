package com.shkubel.project.web;

import com.shkubel.project.models.User;
import com.shkubel.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping()
    public String users (Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users/users";
    }

    @GetMapping ("/administrator")
    public String adminPage () {
       return "/users/administrator";
    }

    @GetMapping ("/new")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
       return "/users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute ("user") User user) {
        userRepository.save(user);
        return "redirect:/home";
    }


    @GetMapping("/{id}")
    public String show (@PathVariable ("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/profile";
    }


}
