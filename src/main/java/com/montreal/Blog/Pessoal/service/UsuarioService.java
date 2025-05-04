package com.montreal.Blog.Pessoal.service;

import com.montreal.Blog.Pessoal.model.Usuario;
import com.montreal.Blog.Pessoal.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario cadastrarUsuario(@Valid Usuario usuarioRequest) {
        if (usuarioRepository.findByEmail(usuarioRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Este email já foi cadastrado");
        }
        return usuarioRepository.save(usuarioRequest);
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, @Valid Usuario usuarioRequest) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRequest.setId(id);
            return usuarioRepository.save(usuarioRequest);
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    @Transactional
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }
}