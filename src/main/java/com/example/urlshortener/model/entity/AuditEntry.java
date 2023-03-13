package com.example.urlshortener.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "audit_entry")
public class AuditEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "shortened_url_id")
    private ShortenedUrl shortenedUrl;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "text")
    private String text;

}
