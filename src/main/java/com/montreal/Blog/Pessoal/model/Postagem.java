package com.montreal.Blog.Pessoal.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "postagem")
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    private String titulo;

    @NotBlank(message = "O texto não pode estar vazio")
    @Column(columnDefinition = "TEXT")
    private String texto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data = LocalDateTime.now();

    @NotNull(message="O id do tema não pode ser null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @NotNull(message="O id do usuario não pode ser null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Postagem() {
    }

    public Postagem(Long id, String titulo, String texto, LocalDateTime data, Tema tema, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
        this.tema = tema;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}