package com.montreal.Blog.Pessoal.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioLogin {

    private Long id;

    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O usuário não pode estar vazio")
    @Email(message = "O usuário deve ser um e-mail válido")
    private String usuario;

    @NotBlank(message = "A senha não pode estar vazia")
    private String senha;

    private String foto;
    private String token;

    public UsuarioLogin(Long id, String nome, String usuario, String senha, String foto, String token) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.foto = foto;
        this.token = token;
    }
}
