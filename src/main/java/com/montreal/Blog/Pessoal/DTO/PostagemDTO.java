package com.montreal.Blog.Pessoal.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostagemDTO {
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    private String titulo;

    @NotBlank(message = "O conteúdo não pode estar vazio")
    private String conteudo;  // Considerando a mudança do nome de 'texto' para 'conteudo', se necessário.

    @NotNull(message = "O id do tema não pode ser nulo")
    private Long temaId;

    @NotNull(message = "O id do usuário não pode ser nulo")
    private Long usuarioId;


}
