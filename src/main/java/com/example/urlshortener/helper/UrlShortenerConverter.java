package com.example.urlshortener.helper;

import com.example.urlshortener.model.dto.CreateShortUrlDto;
import com.example.urlshortener.model.entity.ShortenedUrl;
import com.example.urlshortener.model.request.CreateShortUrlRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.example.urlshortener.model.LinkStatus.ACTIVE;

@Component
public class UrlShortenerConverter {

    public static ShortenedUrl requestToEntity(CreateShortUrlRequest request) {
        return ShortenedUrl.builder()
                .targetURL(request.getTargetURL())
                .shortenedCode(request.getShortenedCode())
                .creatorEmail(request.getCreatorEmail())
                .creationDate(LocalDateTime.now())
                .status(ACTIVE)
                .build();
    }

    public static CreateShortUrlDto entityToDto(ShortenedUrl shortenedUrl) {
        return CreateShortUrlDto.builder()
                .targetURL(shortenedUrl.getTargetURL())
                .shortenedCode(shortenedUrl.getShortenedCode())
                .creationDate(shortenedUrl.getCreationDate())
                .status(shortenedUrl.getStatus())
                .build();
    }
}
