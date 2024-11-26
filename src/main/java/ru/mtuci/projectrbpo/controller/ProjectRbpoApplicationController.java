package ru.mtuci.projectrbpo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectRbpoApplicationController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}