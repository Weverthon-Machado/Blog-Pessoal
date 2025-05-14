package com.montreal.Blog.Pessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "tema")
public class Tema {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="A descrição é obrigatória")
    private String descricao;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Postagem> postagens;

    public Tema() {
    }

    public Tema(Long id, String descricao, Collection<Postagem> postagens) {
        this.id = id;
        this.descricao = descricao;
        this.postagens = postagens;
    }

}