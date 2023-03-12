package com.example.urlshortener.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateShortURLRequest {
    @NonNull
    private String targetURL;
    private String shortenedCode;
    @NonNull
    private String creatorEmail;
}
