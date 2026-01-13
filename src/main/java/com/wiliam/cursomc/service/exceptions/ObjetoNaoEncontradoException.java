package com.wiliam.cursomc.service.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

    public ObjetoNaoEncontradoException(String msg){
        super(msg);
    }

    public ObjetoNaoEncontradoException(String msg,Throwable causa){
        super(msg,causa);
    }

}
