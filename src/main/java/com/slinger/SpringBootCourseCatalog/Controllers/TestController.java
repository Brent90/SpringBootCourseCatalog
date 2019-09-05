package com.slinger.SpringBootCourseCatalog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class TestController {

    @GetMapping("/test")
    public String showTestPage() {
        System.out.println("success");
        return "test-page";
    }



}
