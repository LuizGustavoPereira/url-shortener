package com.example.urlshortener.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {
    @Value("${code-generator.codeLength:10}")
    private int codeLength;
    @Value("${code-generator.numbers:false}")
    private boolean numbers;
    @Value("${code-generator.letters:true}")
    private boolean letters;
    public String generate() {
        return RandomStringUtils.random(codeLength, letters, numbers);
    }


}
