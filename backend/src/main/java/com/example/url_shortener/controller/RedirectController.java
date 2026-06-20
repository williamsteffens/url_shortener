package com.example.url_shortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class RedirectController {
    
    @Value("${app.frontend-url}")
    private String frontendUrl;

    @GetMapping("/")
    public String redirectToFrontend() {
        return "redirect:" + frontendUrl;
    }

    // TODO: Add a catch-all route to handle all other paths and redirect to the frontend
    
    // TODO: move /{code} to this controller and handle the redirection logic here
}
