package com.wiliam.cursomc.resouces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiliam.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @GetMapping
    public List<Categoria> listar(){

        Categoria c1 = new Categoria(01, "Escritorio");
        Categoria c2 =new Categoria(02,"informatica");

        List <Categoria> lista = new ArrayList<>();
        lista.add(c2);
        lista.add(c1);
        return lista;
    }

}
