package com.montreal.Blog.Pessoal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    @GetMapping
    public ResponseEntity<String> getResource() {

        boolean resourceExists = false;

        if (!resourceExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado");
        }

        return ResponseEntity.ok("Recurso encontrado");
    }
}