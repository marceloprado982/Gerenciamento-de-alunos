package br.com.mentorama.cadastroaluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final List<Aluno> alunos;
    public AlunoService() {
        this.alunos = new ArrayList<>();
    }


    public List<Aluno> findAll (String aluno){
        return alunos;
    }
    public Aluno findAluno (String aluno) throws AlunoNaoEncontradoException{
        return findAll(aluno).stream()
                .filter(aluno1 -> alunos.equals(aluno1))
                .findFirst().orElseThrow(() -> new AlunoNaoEncontradoException(aluno));
    }

    public Aluno findByIdade (Integer idade){
        return this.alunos.stream()
                .filter(aln ->aln.getIdade().equals(idade))
                .findFirst().orElse(null);
    }

    public Aluno findById (Integer id) throws IdNaoEncontradoException{
        return this.alunos.stream()
                .filter(aln ->aln.getId().equals(id))
                .findFirst().orElseThrow(() -> new IdNaoEncontradoException(id));
    }

    public ResponseEntity<Integer> add(final Aluno aluno) {
        if(aluno.getId() == null){
            aluno.setId(alunos.size() + 1);
        }
        alunos.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }

    public ResponseEntity update(final Aluno aluno){
        alunos.stream()
                .filter(aln -> aln.getId().equals(aluno.getId()))
                .forEach(aln -> aln.setAluno(aluno.getAluno()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity delete (Integer id){
        alunos.removeIf(aln->aln.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
