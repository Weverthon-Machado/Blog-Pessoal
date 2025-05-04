package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    @Query("SELECT p FROM Postagem p WHERE p.autor.id = :autorId AND p.tema.id = :temaId")
    List<Postagem> filtrarPorAutorETema(@Param("autorId") Long autorId, @Param("temaId") Long temaId);
}