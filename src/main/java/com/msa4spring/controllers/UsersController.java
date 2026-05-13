package com.msa4spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {
    @GetMapping("/users")
    public String test() {
        return "GET users";
    }

    @PostMapping("/users")
    public String testPost() {
        return "Post users";
    }
}
