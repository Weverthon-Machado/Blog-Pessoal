package com.montreal.Blog.Pessoal.service;

import com.montreal.Blog.Pessoal.model.Tema;
import com.montreal.Blog.Pessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    public List<Tema> listarTemas() {
        return temaRepository.findAll();
    }
}