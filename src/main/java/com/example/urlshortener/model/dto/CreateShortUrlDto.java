package com.example.urlshortener.model.dto;

import com.example.urlshortener.model.LinkStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CreateShortUrlDto {

    private String targetURL;
    private String shortenedCode;
    private LocalDateTime creationDate;
    private LinkStatus status;
}
