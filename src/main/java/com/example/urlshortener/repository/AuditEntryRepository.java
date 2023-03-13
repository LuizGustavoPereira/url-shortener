package com.example.urlshortener.repository;

import com.example.urlshortener.model.entity.AuditEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEntryRepository extends JpaRepository<AuditEntry, Long> {
}
