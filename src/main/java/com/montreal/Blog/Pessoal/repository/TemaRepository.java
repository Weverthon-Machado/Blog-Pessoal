package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
}