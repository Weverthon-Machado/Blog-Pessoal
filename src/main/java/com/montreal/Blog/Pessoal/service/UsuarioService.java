package com.montreal.Blog.Pessoal.service;

import com.montreal.Blog.Pessoal.model.Usuario;
import com.montreal.Blog.Pessoal.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private Long id;

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Long id) {
        this.id = id;
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario cadastrarUsuario(@Valid Usuario usuarioRequest) {
        if(!(null == usuarioRepository.findByUsuario(usuarioRequest.getUsuario()))) {
            throw new RuntimeException("Este email já foi cadastrado");
        }
        return usuarioRepository.save(usuarioRequest);
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, @Valid Usuario usuarioRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRequest.setId(id);
            return usuarioRepository.save(usuarioRequest);
        }
        else{
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