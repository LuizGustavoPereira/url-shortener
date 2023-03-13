package com.example.urlshortener.exception;

public class InvalidUrlException extends RuntimeException {
    public InvalidUrlException(String msg) {
        super(msg);
    }
}
