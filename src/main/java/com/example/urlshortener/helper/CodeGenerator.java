package com.example.urlshortener.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "code-generator")
public class CodeGenerator {
    private int codeLength = 10;
    private boolean numbers = false;
    private boolean letters = true;
    public String generate() {
            return RandomStringUtils.random(codeLength, numbers, letters);
    }


}
