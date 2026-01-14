package com.wiliam.cursomc.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiliam.cursomc.domain.Pedido;
import com.wiliam.cursomc.repositories.PedidoRepository;
import com.wiliam.cursomc.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id){
       Optional <Pedido>obj = repo.findById(id);
       //Retorna um Objeto ou Lança uma exception Personalizda  bjetoNaoEncontradoException
      return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
                            "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));



    }

}
