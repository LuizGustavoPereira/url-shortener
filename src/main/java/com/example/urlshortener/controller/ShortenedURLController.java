package com.example.urlshortener.controller;

import com.example.urlshortener.model.request.CreateShortURLRequest;
import com.example.urlshortener.model.dto.CreateShortULRDto;
import com.example.urlshortener.service.ShortenedURLService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/url-shortener")
public class ShortenedURLController {
    private ShortenedURLService shortenedURLService;
    @PostMapping(value = "/create-shorted-url", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CreateShortULRDto createShortURL(@RequestBody CreateShortURLRequest createShortURLRequest) {
        return shortenedURLService.createShortURL(createShortURLRequest);
    }
}
