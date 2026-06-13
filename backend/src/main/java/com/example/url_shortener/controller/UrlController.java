package com.example.url_shortener.controller;

import com.example.url_shortener.dto.CreateShortUrlRequest;
import com.example.url_shortener.dto.ShortUrlResponse;
import com.example.url_shortener.entity.ShortUrl;
import com.example.url_shortener.mapper.ShortUrlMapper;
import com.example.url_shortener.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final ShortUrlService service;

    @Value("${app.base-url}")
    private String baseUrl;

    public UrlController(ShortUrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortUrlResponse> shorten(@RequestBody CreateShortUrlRequest request) {
        ShortUrl shortUrl = service.create(request.getUrl());

        return ResponseEntity.ok(
                ShortUrlMapper.toDto(shortUrl, baseUrl)
        );
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        return service.getByCode(code)
                .map(url -> {
                    service.incrementClicks(url);
                    return ResponseEntity.status(302)
                            .header("Location", url.getOriginalUrl())
                            .<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}