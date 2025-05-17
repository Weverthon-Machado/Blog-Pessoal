package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.model.Tema;
import com.montreal.Blog.Pessoal.service.TemaService;
import org.springframework.http.HttpStatus;
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
        try {
            List<Tema> temas = temaService.buscarTemas();
            if (temas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(temas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}