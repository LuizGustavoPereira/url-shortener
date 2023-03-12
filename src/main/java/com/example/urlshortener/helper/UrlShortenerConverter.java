package com.example.urlshortener.helper;

import com.example.urlshortener.model.LinkStatus;
import com.example.urlshortener.model.dto.CreateShortULRDto;
import com.example.urlshortener.model.entity.ShortenedURL;
import com.example.urlshortener.model.request.CreateShortURLRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.example.urlshortener.model.LinkStatus.ACTIVE;

@Component
public class UrlShortenerConverter {

    public static ShortenedURL requestToEntity(CreateShortURLRequest request) {
        return ShortenedURL.builder()
                .targetURL(request.getTargetURL())
                .shortenedCode(request.getShortenedCode())
                .creatorEmail(request.getCreatorEmail())
                .creationDate(LocalDateTime.now())
                .status(ACTIVE)
                .build();
    }

    public static CreateShortULRDto entityToDto(ShortenedURL shotShortenedURL) {
        return CreateShortULRDto.builder()
                .targetURL(shotShortenedURL.getTargetURL())
                .shortenedCode(shotShortenedURL.getShortenedCode())
                .creationDate(shotShortenedURL.getCreationDate())
                .status(shotShortenedURL.getStatus())
                .build();
    }
}
