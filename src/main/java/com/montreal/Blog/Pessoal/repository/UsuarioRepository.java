package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    Usuario save(Usuario usuario);
}