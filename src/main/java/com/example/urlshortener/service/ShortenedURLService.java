package com.example.urlshortener.service;

import com.example.urlshortener.helper.CodeGenerator;
import com.example.urlshortener.model.request.CreateShortURLRequest;
import com.example.urlshortener.model.dto.CreateShortULRDto;
import com.example.urlshortener.repository.ShortenedURLRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.urlshortener.helper.UrlShortenerConverter.entityToDto;
import static com.example.urlshortener.helper.UrlShortenerConverter.requestToEntity;

@Service
@AllArgsConstructor
@Slf4j
public class ShortenedURLService {
    private CodeGenerator codeGenerator;
    private ShortenedURLRepository shortenedURLRepository;
    public CreateShortULRDto createShortURL(CreateShortURLRequest createShortURLRequest) {
        if(createShortURLRequest.getShortenedCode().isBlank()) {
            createShortURLRequest.setShortenedCode(codeGenerator.generate());
        }
        log.info("Creating new URL Shortener.");
        return entityToDto(shortenedURLRepository.save(requestToEntity(createShortURLRequest)));

    }
}
