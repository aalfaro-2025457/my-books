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
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.existsByUsername(user.getUsername())) {
            // Sends an error message back to the view
            model.addAttribute("error", "Username is already taken");
            return "auth/register";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.login(username, password);
        if (user != null) {
            return "redirect:/books?userId=" + user.getIdUser();
        }
        model.addAttribute("error", "Invalid username or password");
        return "auth/login";
    }

    @GetMapping("/")
    public String redirectToRegister() {
        // Redirects the root URL to the registration page
        return "redirect:/register";
    }
}