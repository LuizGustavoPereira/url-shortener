package com.example.urlshortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "audit_entry")
public class AuditEntry {
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "shortened_url_id")
    private String ShortenedURL;
    private LocalDateTime creationDate;
    private String text;

}
