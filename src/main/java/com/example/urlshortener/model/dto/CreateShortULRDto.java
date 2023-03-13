package com.example.urlshortener.model.dto;

import com.example.urlshortener.model.LinkStatus;
import lombok.Builder;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDateTime;

@Builder
public class CreateShortULRDto {

    private String targetURL;
    private String shortenedCode;
    private LocalDateTime creationDate;
    private LinkStatus status;
}
