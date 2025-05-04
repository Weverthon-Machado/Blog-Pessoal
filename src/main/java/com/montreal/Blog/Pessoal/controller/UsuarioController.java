package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.model.Usuario;
import com.montreal.Blog.Pessoal.service.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuario(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        if (usuario == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            logger.error("Dados inválidos: usuário ou campos obrigatórios estão nulos.");
            return ResponseEntity.badRequest().build();
        }

        try {
            logger.info("Recebida solicitação para cadastrar usuário: {}", usuario.getEmail());
            Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);

            if (novoUsuario == null) {
                logger.error("Erro ao cadastrar: o serviço retornou nulo.");
                return ResponseEntity.internalServerError().build();
            }

            logger.info("Usuário cadastrado com sucesso: {}", novoUsuario.getId());
            return ResponseEntity.created(URI.create("/usuarios/" + novoUsuario.getId())).body(novoUsuario);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de argumento inválido: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Erro inesperado ao cadastrar usuário: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}