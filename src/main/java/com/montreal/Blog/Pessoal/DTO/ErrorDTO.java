package com.montreal.Blog.Pessoal.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorDTO {
    // Getters and Setters
    private String message;
    private String details;

    public ErrorDTO(String message, String details) {
        this.message = message;
        this.details = details;
    }

}
