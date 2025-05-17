package com.montreal.Blog.Pessoal.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
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
        LocalDateTime nowUtc = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        this.timestamp = nowUtc.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }
}
