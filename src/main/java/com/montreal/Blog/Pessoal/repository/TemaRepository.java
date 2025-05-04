package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long> {

    @Query("SELECT t FROM Tema t WHERE t.nome LIKE %:nome%")
    List<Tema> findByNomeContaining(@Param("nome") String nome);
}