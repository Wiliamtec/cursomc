package com.wiliam.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable{
  private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    //produtos é o nome do papael no nosso modelo conceitual
    //no caso de REferencia Ciclica (Quando um referencia chama uma lista de objetos e esse Objeto chama a lista do objeto anterior e esse processo ocorre indefinidamente)
    //Para isso devemos definir qual o objeto possuira uma lista de um objeto sem entrar em loop
    // nesse casso nosso endpoint consuta categoria trara uma lista de produtos , para isso marcamos no relacionamento de Categoria com Produto
    //@JsonManagedReference e do outro lado do relacionamento @JsonBackReference (Que diz que o outro lado da associação ja buscou os objetos e sendo assim não buscara mais)
    
    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();

    public Categoria(){

    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    //Implementação padrão do hash code e equals somente id 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    

}
