package com.example.url_shortener.controller;

import com.example.url_shortener.entity.ShortUrl;
import com.example.url_shortener.exceptions.UrlNotFoundException;
import com.example.url_shortener.service.ShortUrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

@RestController
public class RedirectController {
    
    @Value("${app.frontend-url}")
    private String frontendUrl;

    private final ShortUrlService service;

    public RedirectController(ShortUrlService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<Void> home() {
        return ResponseEntity.status(302)
                .header("Location", frontendUrl)
                .build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        ShortUrl url = service.getByCode(code)
            .orElseThrow(UrlNotFoundException::new);

        service.incrementClicks(url);

        return ResponseEntity.status(302)
                .header("Location", url.getOriginalUrl())
                .build();
    }
}
