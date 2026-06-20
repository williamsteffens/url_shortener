package com.example.url_shortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

@RestController
public class RedirectController {
    
    @Value("${app.frontend-url}")
    private String frontendUrl;

    @GetMapping("/")
    public ResponseEntity<Void> home() {
        return ResponseEntity.status(302)
                .header("Location", frontendUrl)
                .build();
    }

    // TODO: Add a catch-all route to handle all other paths and redirect to the frontend
    
    // TODO: move /{code} to this controller and handle the redirection logic here
}
