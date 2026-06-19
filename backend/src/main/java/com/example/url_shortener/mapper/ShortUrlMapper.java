package com.example.url_shortener.mapper;

import com.example.url_shortener.dto.ShortUrlResponse;
import com.example.url_shortener.entity.ShortUrl;

public class ShortUrlMapper {

    public static ShortUrlResponse toDto(ShortUrl entity, String combinedUrl) {
        return new ShortUrlResponse(
                entity.getId(),
                entity.getOriginalUrl(),
                entity.getShortCode(),
                entity.getClicks(),
                combinedUrl
        );
    }
}