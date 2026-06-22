package com.example.url_shortener.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException() {
        super(ErrorMessages.URL_NOT_FOUND.getMessage());
    }
}
