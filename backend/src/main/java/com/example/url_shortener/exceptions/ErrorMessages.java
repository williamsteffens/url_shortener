package com.example.url_shortener.exceptions;

public enum ErrorMessages {
    URL_NOT_FOUND("URL not found");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
