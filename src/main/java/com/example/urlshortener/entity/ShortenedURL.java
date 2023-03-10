package com.example.urlshortener.entity;

import com.example.urlshortener.model.LinkStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "ShortenedURL")
public class ShortenedURL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "creator_email", nullable = false)
    private String creatorEmail;
    @Column(name = "target_url", nullable = false)
    private String targetURL;
    @Column(name = "shortened_code", nullable = false, unique = true)
    private String shortenedCode;
    @Enumerated(EnumType.ORDINAL)
    private LinkStatus status;
}
