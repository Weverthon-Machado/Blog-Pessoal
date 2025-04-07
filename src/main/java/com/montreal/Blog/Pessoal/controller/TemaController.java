package com.montreal.Blog.Pessoal.controller;

import com.montreal.Blog.Pessoal.model.Tema;
import com.montreal.Blog.Pessoal.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @GetMapping
    public List<Tema> getTemas() {
        return temaService.listarTemas();
    }
}