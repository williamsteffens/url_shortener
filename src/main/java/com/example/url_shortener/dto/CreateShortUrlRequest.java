package com.example.url_shortener.dto;

import lombok.*;

@Getter
@Setter
public class CreateShortUrlRequest {
    private String url;
}