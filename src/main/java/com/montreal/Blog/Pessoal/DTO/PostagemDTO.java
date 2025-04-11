package com.montreal.Blog.Pessoal.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostagemDTO {
    private Long id;
    private String titulo;
    private String conteudo;
    private Long temaId;
    private Long usuarioId;

}