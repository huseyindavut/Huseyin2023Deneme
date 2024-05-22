package com.example.huseyin2023deneme;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitizenController {
    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/hello")
    public String hello() {return "Your controller is working"}


}
