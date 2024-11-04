package main.java.com.testes.services;

import main.java.com.testes.interfaces.IAlunoRepository;
import main.java.com.testes.entities.Aluno;

public class AlunoService {
    private IAlunoRepository alunoRepository;

    public AlunoService(IAlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public String cadastrarAluno(String nome, String matricula) {
        if (alunoRepository.buscarPorMatricula(matricula) != null) {
            return "Aluno já cadastrado";
        }
        Aluno novoAluno = new Aluno(nome, matricula);
        alunoRepository.salvar(novoAluno);
        return "Aluno cadastrado com sucesso";
    }
}
