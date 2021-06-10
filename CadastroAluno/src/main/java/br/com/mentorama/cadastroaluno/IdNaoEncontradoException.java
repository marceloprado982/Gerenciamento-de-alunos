package br.com.mentorama.cadastroaluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IdNaoEncontradoException extends Exception{
    public IdNaoEncontradoException(Integer id) {
        super(new ResponseEntity(HttpStatus.NOT_FOUND) +  "id não encontrado!");
    }
}
