package com.slinger.SpringBootCourseCatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showTestPage() {
        return "public-landing-page";
    }

    @GetMapping("/login")
    public String login() {
        return "login-page";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home-page";
    }


}
