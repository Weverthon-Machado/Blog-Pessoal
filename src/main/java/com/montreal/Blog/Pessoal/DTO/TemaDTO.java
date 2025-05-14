package com.montreal.Blog.Pessoal.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TemaDTO {
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
}
