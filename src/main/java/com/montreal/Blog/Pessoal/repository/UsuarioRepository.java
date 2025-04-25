package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.model.Usuario;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    default Usuario findByEmail() {
        return findByEmail(null);
    }

    default Usuario findByEmail(String ignoredEmail) {
        return null;
    }

    default @NotNull Usuario save(Usuario usuario) {
        return null;
    }
}