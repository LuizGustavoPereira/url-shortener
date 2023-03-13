package com.example.urlshortener;

import com.example.urlshortener.exception.InvalidUrlException;
import com.example.urlshortener.helper.CodeGenerator;
import com.example.urlshortener.model.dto.CreateShortUrlDto;
import com.example.urlshortener.model.entity.ShortenedUrl;
import com.example.urlshortener.model.request.CreateShortUrlRequest;
import com.example.urlshortener.repository.ShortenedUrlRepository;
import com.example.urlshortener.service.AuditEntryService;
import com.example.urlshortener.service.ShortenedUrlService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.example.urlshortener.model.LinkStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShortenedUrlServiceTest {
    private CodeGenerator codeGenerator = mock(CodeGenerator.class);
    private ShortenedUrlRepository shortenedURLRepository = mock(ShortenedUrlRepository.class);
    private AuditEntryService auditEntryService = mock(AuditEntryService.class);
    private ShortenedUrlService shortenedUrlService = new ShortenedUrlService(codeGenerator, shortenedURLRepository, auditEntryService);

    @Test
    public void createShortUrlHappyPath() {
        when(shortenedURLRepository.save(any())).thenReturn(createShortenedUrl());
        CreateShortUrlDto response = shortenedUrlService.createShortURL(createMockRequest());
         assertEquals("https://www.google.com", response.getTargetURL());
    }

    @Test
    public void createShortUrlBadRequest() {
        when(shortenedURLRepository.save(any())).thenReturn(createShortenedUrl());
        CreateShortUrlRequest request = createMockRequest();
        request.setTargetURL("abxcadassad");
        assertThrows(InvalidUrlException.class, () -> {
            shortenedUrlService.createShortURL(request);
        });
    }

    private CreateShortUrlRequest createMockRequest() {
        return CreateShortUrlRequest.builder()
                .creatorEmail("mockEmail@gmail.com")
                .shortenedCode("abc")
                .targetURL("https://www.google.com")
                .build();
    }

    private ShortenedUrl createShortenedUrl() {
        return ShortenedUrl.builder()
                .creationDate(LocalDateTime.now())
                .shortenedCode("abc")
                .status(ACTIVE)
                .targetURL("https://www.google.com")
                .creatorEmail("mockEmail@gmail.com")
                .id(1234L)
                .build();
    }
}
