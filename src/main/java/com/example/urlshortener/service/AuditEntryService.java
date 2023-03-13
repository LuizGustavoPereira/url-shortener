package com.example.urlshortener.service;

import com.example.urlshortener.model.dto.CreateShortUrlDto;
import com.example.urlshortener.model.entity.AuditEntry;
import com.example.urlshortener.model.entity.ShortenedUrl;
import com.example.urlshortener.repository.AuditEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AuditEntryService {
    AuditEntryRepository auditEntryRepository;

    public void auditCreateShortenedUrl(ShortenedUrl shortenedUrl) {
        auditEntryRepository.save(createAuditEntry(shortenedUrl));
    }

    private AuditEntry createAuditEntry(ShortenedUrl shortenedUrl) {
        return AuditEntry.builder()
                .creationDate(LocalDateTime.now())
                .shortenedUrl(shortenedUrl)
                .text("New shortened URL created")
                .build();
    }
}
