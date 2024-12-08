package ru.mtuci.projectrbpo.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectRbpoApplicationController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}

