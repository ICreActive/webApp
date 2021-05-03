package com.shkubel.project.web;

import com.shkubel.project.models.User;
import com.shkubel.project.repo.UserRepository;
import com.shkubel.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping()
    public String users(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users/users";
    }

    @GetMapping("/administrator")
    public String adminPage() {
        return "/users/administrator";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("userNew") User user) {
        return "users/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("userNew") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/users/new";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "/users/new";
        }
        if (!userService.saveUser(user)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "/users/new";
        }
        userService.saveUser(user);

        return "redirect:/home";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String userEdit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "users/edit";
    }

    @PostMapping("/profile/{id}/edit")
    public String userUpd(@ModelAttribute ("user") @Valid User user,
                          BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }


    @PostMapping()
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/users";
    }

}
