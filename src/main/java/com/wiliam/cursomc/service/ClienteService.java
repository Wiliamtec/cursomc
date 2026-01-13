package com.wiliam.cursomc.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiliam.cursomc.domain.Cliente;
import com.wiliam.cursomc.repositories.ClienteRepository;
import com.wiliam.cursomc.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
       Optional <Cliente>obj = repo.findById(id);
       //Retorna um Objeto ou Lança uma exception Personalizda  bjetoNaoEncontradoException
      return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
                            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));



    }

}
