package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.model.Postagem;
import com.montreal.Blog.Pessoal.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/postagens")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @GetMapping
    public ResponseEntity<List<Postagem>> readPostagens() {
        List<Postagem> listsPostage = postagemService.buscarPostagems();
        if (listsPostage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listsPostage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPostagem(@Valid @RequestBody Postagem postagemRequest) {
        try{
            Postagem postagem = postagemService.cadastrarPostagem(postagemRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Postagem postagemRequest) {
        try{
            Postagem postagem = postagemService.atualizarPostagem(id, postagemRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            postagemService.deletarPostagem(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
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
    public ResponseEntity<Optional<Postagem>> buscarPorId(@PathVariable Long id) {
        Optional<Postagem> postage = Optional.ofNullable(postagemService.buscarPostagem(id));
        if (postage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(postage);
    }
}