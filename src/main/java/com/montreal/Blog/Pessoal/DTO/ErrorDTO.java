package com.montreal.Blog.Pessoal.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class ErrorDTO {

    private String message;
    private String details;
    private String timestamp;

    public ErrorDTO(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now());
    }
}
