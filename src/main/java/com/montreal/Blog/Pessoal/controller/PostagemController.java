package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.DTO.ErrorDTO;
import com.montreal.Blog.Pessoal.model.Postagem;
import com.montreal.Blog.Pessoal.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postagens")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping
    public ResponseEntity<List<Postagem>> readPostagens() {
        List<Postagem> listsPostage = postagemService.buscarPostagems();
        if (listsPostage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listsPostage);
    }

    @PostMapping
    public ResponseEntity<?> createPostagem(@Valid @RequestBody Postagem postagemRequest) {
        try {
            Postagem postagem = postagemService.cadastrarPostagem(postagemRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO("Erro ao criar postagem", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Postagem postagemRequest) {
        try {
            Postagem postagem = postagemService.atualizarPostagem(id, postagemRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
        } catch (Exception e) {
            // Retorne um ResponseEntity com ErrorDTO para erros
            ErrorDTO errorDTO = new ErrorDTO("Erro ao atualizar postagem", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            postagemService.deletarPostagem(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO("Erro ao deletar postagem", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Postagem>> filtrarPostagens(
            @RequestParam(required = false) Long autor,
            @RequestParam(required = false) Long tema) {
        List<Postagem> postagensFiltradas = postagemService.filtrarPorAutorETema(autor, tema);
        return ResponseEntity.ok(postagensFiltradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Postagem postagem = postagemService.buscarPostagem(id);
        if (postagem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(postagem);
    }
}
