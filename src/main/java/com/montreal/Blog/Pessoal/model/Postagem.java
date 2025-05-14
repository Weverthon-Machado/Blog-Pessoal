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
@Getter
@Setter
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

}
