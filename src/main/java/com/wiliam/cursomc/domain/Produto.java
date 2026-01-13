package com.wiliam.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;
    
    //Quando temos uma relação muitos para muitos , temo que criar uma tabela intermediaria
    // a anotation @jointable ele definira que sera a tabela intermediaria em nosso banco de dados 
    // @JsonBackReference (Que diz que o outro lado da associação ja buscou os objetos e sendo assim não buscara mais)
    @JsonBackReference
    @ManyToAny
    @JoinTable(name = "Produto_Categoria",
               joinColumns = @JoinColumn(name = "produto_id"), // campo da tabela correspondente FK do Produto (classe onde estamos)
               inverseJoinColumns = @JoinColumn(name = "categoria_id")// campo da tabela correspondente FK do categoria (Outra Classe Relacionada)
    )
    private List<Categoria>categorias= new ArrayList<>();

    public Produto(){

    }

    //Cria Construtor sobre carregado sem a coleção pois ja foi iniciada acima
    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

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
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    


}
