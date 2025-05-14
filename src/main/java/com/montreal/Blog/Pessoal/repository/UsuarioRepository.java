package com.montreal.Blog.Pessoal.repository;

import com.montreal.Blog.Pessoal.DTO.UsuarioLogin;
import com.montreal.Blog.Pessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT new com.montreal.Blog.Pessoal.DTO.UsuarioLogin(u.id, u.nome, u.usuario, u.senha, u.foto, :token) " +
            "FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    Optional<UsuarioLogin> autenticar(@Param("email") String email, @Param("senha") String senha, @Param("token") String token);

}
