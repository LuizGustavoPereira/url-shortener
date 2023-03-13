package com.example.urlshortener.model.entity;

import com.example.urlshortener.model.LinkStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "SHORTENED_URL")
public class ShortenedUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "target_url", nullable = false)
    private String targetURL;
    @Column(name = "shortened_code", nullable = false, unique = true)
    private String shortenedCode;
    @Column(name = "creator_email", nullable = false)
    private String creatorEmail;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LinkStatus status;
}
