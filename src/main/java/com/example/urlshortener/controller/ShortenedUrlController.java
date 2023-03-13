package com.example.urlshortener.controller;

import com.example.urlshortener.model.dto.CreateShortUrlDto;
import com.example.urlshortener.model.request.CreateShortUrlRequest;
import com.example.urlshortener.service.ShortenedUrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/url-shortener")
public class ShortenedUrlController {
    private ShortenedUrlService shortenedURLService;
    @PostMapping(value = "/create-shorted-url", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateShortUrlDto> createShortURL(@RequestBody CreateShortUrlRequest createShortUrlRequest) {
        shortenedURLService.createShortURL(createShortUrlRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{code}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> callUrl(@PathVariable("code") String code, HttpServletRequest request) {
        return ResponseEntity.status(FOUND)
                .location(URI.create(shortenedURLService.findUrlByCode(code, request.getRemoteAddr())))
                .build();
    }
}
