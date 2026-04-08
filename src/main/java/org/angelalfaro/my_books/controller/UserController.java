package org.angelalfaro.my_books.controller;

import lombok.RequiredArgsConstructor;
import org.angelalfaro.my_books.entity.User;
import org.angelalfaro.my_books.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, Model model) {
        User user = userService.login(username);
        if (user != null) {
            // Passing the ID via redirect to simulate a session
            return "redirect:/books?userId=" + user.getIdUser();
        }
        model.addAttribute("error", "Invalid username");
        return "auth/login";
    }

    @GetMapping("/")
    public String redirectToRegister() {
        // Redirects the root URL to the registration page
        return "redirect:/register";
    }
}