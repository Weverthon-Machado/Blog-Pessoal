package com.montreal.Blog.Pessoal.service;

import com.montreal.Blog.Pessoal.model.Tema;
import com.montreal.Blog.Pessoal.repository.TemaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService {
    @Autowired
    private TemaRepository temaRepository;

    public List<Tema> buscarTemas() {
        return temaRepository.findAll();
    }

    public Tema buscarTema(Long id) {
        Optional<Tema> tema = temaRepository.findById(id);
        return tema.orElse(null);
    }

    public Tema cadastrarTema(@Valid Tema tema) {
        return temaRepository.save(tema);
    }

    @Transactional
    public Tema atualizarTema(Long id, @Valid Tema tema) {
        Optional<Tema> temaOptional = temaRepository.findById(id);

        if (temaOptional.isPresent()) {
            tema.setId(id);
            return temaRepository.save(tema);
        } else {
            throw new RuntimeException("Tema não encontrado");
        }
    }

    @Transactional
    public void deletarTema(Long id) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tema não encontrado"));
        temaRepository.delete(tema);
    }

    public List<Tema> listarTemas() {
        return List.of();
    }
}