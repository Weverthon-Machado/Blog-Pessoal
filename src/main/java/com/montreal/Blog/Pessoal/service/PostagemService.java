package com.montreal.Blog.Pessoal.service;

import com.montreal.Blog.Pessoal.model.Postagem;
import com.montreal.Blog.Pessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem createPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }
}