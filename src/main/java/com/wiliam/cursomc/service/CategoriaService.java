package com.wiliam.cursomc.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiliam.cursomc.domain.Categoria;
import com.wiliam.cursomc.repositories.CategoriaRepository;
import com.wiliam.cursomc.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
       Optional <Categoria>obj = repo.findById(id);
       //Retorna um Objeto ou Lança uma exception Personalizda  bjetoNaoEncontradoException
      return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
                            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));



    }

}
