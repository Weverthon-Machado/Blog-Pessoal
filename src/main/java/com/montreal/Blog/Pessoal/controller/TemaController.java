package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.model.Tema;
import com.montreal.Blog.Pessoal.service.TemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    private final TemaService temaService;

    public TemaController(TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping
    public ResponseEntity<List<Tema>> getTemas() {
        List<Tema> temas = temaService.listarTemas();
        if (temas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(temas);
    }
}