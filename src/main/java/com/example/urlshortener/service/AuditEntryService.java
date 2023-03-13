package com.example.urlshortener.service;

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
        auditEntryRepository.save(createAuditEntry(shortenedUrl, "New shortened URL created"));
    }
    public void auditLinkClicked(ShortenedUrl shortenedUrl, String remoteAddress) {
        auditEntryRepository.save(createAuditEntry(shortenedUrl, "Link Clicked from remote address: " + remoteAddress));
    }
    private AuditEntry createAuditEntry(ShortenedUrl shortenedUrl, String message) {
        return AuditEntry.builder()
                .creationDate(LocalDateTime.now())
                .shortenedUrl(shortenedUrl)
                .text(message)
                .build();
    }

}
