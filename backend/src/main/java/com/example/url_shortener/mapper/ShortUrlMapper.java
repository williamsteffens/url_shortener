package com.example.url_shortener.mapper;

import com.example.url_shortener.dto.ShortUrlResponse;
import com.example.url_shortener.entity.ShortUrl;

public class ShortUrlMapper {

    public static ShortUrlResponse toDto(ShortUrl entity, String baseUrl) {
        return new ShortUrlResponse(
                entity.getOriginalUrl(),
                baseUrl + "/api/" + entity.getShortCode(),
                entity.getClicks()
        );
    }
}