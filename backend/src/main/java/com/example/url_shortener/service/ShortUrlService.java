package com.example.url_shortener.service;

import com.example.url_shortener.entity.ShortUrl;
import com.example.url_shortener.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ShortUrlService {

    private final ShortUrlRepository repository;
    private final Random random = new Random();

    public ShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    public ShortUrl create(String url) {
        ShortUrl entity = new ShortUrl();
        entity.setOriginalUrl(url);
        entity.setShortCode(generateCode());
        return repository.save(entity);
    }

    public Optional<ShortUrl> getByCode(String code) {
        return repository.findByShortCode(code);
    }

    public void incrementClicks(ShortUrl url) {
        url.setClicks(url.getClicks() + 1);
        repository.save(url);
    }

    private String generateCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}