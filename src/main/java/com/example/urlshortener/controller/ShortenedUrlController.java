package com.example.urlshortener.controller;

import com.example.urlshortener.model.request.CreateShortUrlRequest;
import com.example.urlshortener.model.dto.CreateShortUrlDto;
import com.example.urlshortener.service.ShortenedUrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/url-shortener")
public class ShortenedUrlController {
    private ShortenedUrlService shortenedURLService;
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateShortUrlDto> createShortURL(@RequestBody CreateShortUrlRequest createShortUrlRequest) {
        shortenedURLService.createShortURL(createShortUrlRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
