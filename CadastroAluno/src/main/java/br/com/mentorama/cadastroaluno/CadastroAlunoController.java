package br.com.mentorama.cadastroaluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cadastroaluno")
public class CadastroAlunoController {


    @GetMapping
    public List<Aluno> findAll (String aluno){
       AlunoService alunoService = new AlunoService();
       return alunoService.findAll(aluno);
    }
    @GetMapping("/{aluno}")
    public Aluno findAluno (@PathVariable ("aluno") String aluno) throws AlunoNaoEncontradoException{
        AlunoService alunoService = new AlunoService();
        return alunoService.findAluno(aluno);
    }

    @GetMapping("/{idade}")
    public Aluno findByIdade (@PathVariable ("idade") Integer idade){
        AlunoService alunoService = new AlunoService();
        return alunoService.findByIdade(idade);
    }

    @GetMapping("/{id}")
    public Aluno findById (@PathVariable("id") Integer id) throws IdNaoEncontradoException {
        AlunoService alunoService = new AlunoService();
        return alunoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno) {
        AlunoService alunoService = new AlunoService();
        return alunoService.add(aluno);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Aluno aluno){
        AlunoService alunoService = new AlunoService();
        return alunoService.update(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable ("id") Integer id){
        AlunoService alunoService = new AlunoService();
        return alunoService.delete(id);
    }
}