package com.example.url_shortener.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ShortUrlResponse {
    private String originalUrl;
    private String shortUrl;
    private Long clicks;
}