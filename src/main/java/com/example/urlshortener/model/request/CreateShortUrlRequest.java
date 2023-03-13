package com.example.urlshortener.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateShortUrlRequest {
    @NonNull
    private String targetURL;
    private String shortenedCode;
    @NonNull
    private String creatorEmail;
}
