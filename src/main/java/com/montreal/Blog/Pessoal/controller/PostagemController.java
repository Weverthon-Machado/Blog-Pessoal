package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.model.Postagem;
import com.montreal.Blog.Pessoal.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @PostMapping
    public ResponseEntity<Postagem> create(@RequestBody Postagem postagem) {
        Postagem novaPostagem = postagemService.createPostagem(postagem);
        return ResponseEntity.ok(novaPostagem);
    }
}