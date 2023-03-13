package com.example.urlshortener.service;

import com.example.urlshortener.exception.CodeNotFoundException;
import com.example.urlshortener.exception.InvalidUrlException;
import com.example.urlshortener.helper.CodeGenerator;
import com.example.urlshortener.helper.UrlValidator;
import com.example.urlshortener.model.entity.ShortenedUrl;
import com.example.urlshortener.model.request.CreateShortUrlRequest;
import com.example.urlshortener.model.dto.CreateShortUrlDto;
import com.example.urlshortener.repository.ShortenedUrlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.urlshortener.helper.UrlShortenerConverter.entityToDto;
import static com.example.urlshortener.helper.UrlShortenerConverter.requestToEntity;

@Service
@AllArgsConstructor
@Slf4j
public class ShortenedUrlService {
    private CodeGenerator codeGenerator;
    private ShortenedUrlRepository shortenedURLRepository;
    private AuditEntryService auditEntryService;
    public CreateShortUrlDto createShortURL(CreateShortUrlRequest createShortURLRequest) {
        if(!UrlValidator.isValidURL(createShortURLRequest.getTargetURL())) {
            throw new InvalidUrlException("The requested URL is invalid: " + createShortURLRequest.getTargetURL());
        }
        if(createShortURLRequest.getShortenedCode() == null || createShortURLRequest.getShortenedCode().isBlank()) {
            createShortURLRequest.setShortenedCode(codeGenerator.generate());
        }
        log.info("Creating new URL Shortener.");

        ShortenedUrl shortenedUrl =
                shortenedURLRepository.save(requestToEntity(createShortURLRequest));

        auditEntryService.auditCreateShortenedUrl(shortenedUrl);

        return entityToDto(shortenedUrl);

    }

    public String findUrlByCode(String code, String remoteAddress) {
        ShortenedUrl shortenedUrl = shortenedURLRepository.
                findByShortenedCode(code).orElseThrow(() ->
                        new CodeNotFoundException("Invalid Code: " + code)
                );
        auditEntryService.auditLinkClicked(shortenedUrl, remoteAddress);
        return shortenedUrl.getTargetURL();
    }
}
