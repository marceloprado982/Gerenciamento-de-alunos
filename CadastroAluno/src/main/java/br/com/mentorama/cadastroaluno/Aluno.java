package br.com.mentorama.cadastroaluno;

public class Aluno {
    private String aluno;
    private Integer id;
    private Integer idade;

    public Aluno(String aluno, Integer id, Integer idade) {
        this.aluno = aluno;
        this.id = id;
        this.idade = idade;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
