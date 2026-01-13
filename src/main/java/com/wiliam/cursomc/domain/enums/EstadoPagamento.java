package com.wiliam.cursomc.domain.enums;

public enum EstadoPagamento {

    //Enum com controle manual de qual codigo numerico corresponde a cada valor da enumerção
    //é necessario criar um construtor para atribuir os valores para o tipo enumerado
    PENDENTE(1,"Pendente"),
    QUITADO(2,"Quitado"),
    CANCELADO(3,"Cancelado");


    private int cod;
    private String descricao;

    //construtor de tipos Enumerado é Private

    private EstadoPagamento(int cod , String descricao){
        this.cod = cod;
        this.descricao = descricao;

    }

    //uma vez que estanciamos o tipo enumerado NÃO mudamos mais o seus valores por isso utilizamos apenas os metodos getters

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    //operação que recebe um codigo e retorna um objeto do tipo  TipoCliente ja estanciado conforme o codigo passado
    // o metodo tem que ser statico para possibilitar seu mesmo que tenha estanciado o ojeto
    public static EstadoPagamento toEnum(Integer cod){
        if (cod==null) {
            return null;
        }

        for(EstadoPagamento x:EstadoPagamento.values()){
           if (cod.equals(x.getCod())) {
            return x;
           }
        }
        throw new IllegalArgumentException("id Invalido: "+cod);
    }



}
