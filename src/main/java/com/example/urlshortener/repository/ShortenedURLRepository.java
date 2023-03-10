package com.example.urlshortener.repository;

import com.example.urlshortener.entity.ShortenedURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenedURLRepository extends JpaRepository<ShortenedURL, Long> {
    Optional<ShortenedURL> findByCode(String code);
}
