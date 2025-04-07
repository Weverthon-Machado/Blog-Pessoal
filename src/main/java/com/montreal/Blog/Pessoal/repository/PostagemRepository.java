package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}