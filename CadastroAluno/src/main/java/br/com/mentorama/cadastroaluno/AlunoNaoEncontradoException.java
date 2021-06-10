package br.com.mentorama.cadastroaluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AlunoNaoEncontradoException extends Exception{
    public AlunoNaoEncontradoException(String aluno) {
        super(new ResponseEntity(HttpStatus.NOT_FOUND) + "Aluno(a)" + aluno + "não encontrado");
    }
}
