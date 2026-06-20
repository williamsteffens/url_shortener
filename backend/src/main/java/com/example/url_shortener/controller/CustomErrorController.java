package com.example.url_shortener.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class CustomErrorController {

    @Value("${app.frontend-url}")
    private String frontendUrl;

    @RequestMapping("/error")
    public ResponseEntity<Void> handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(302)
                        .header("Location", frontendUrl + "/404")
                        .build();
            }
        }

        return ResponseEntity.status(500).build();
    }
}