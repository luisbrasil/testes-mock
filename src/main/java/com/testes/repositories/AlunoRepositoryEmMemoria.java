package com.testes.repositories;
import java.util.ArrayList;
import java.util.List;

import com.testes.entities.Aluno;
import com.testes.interfaces.IAlunoRepository;

public class AlunoRepositoryEmMemoria implements IAlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        return alunos.stream()
                .filter(aluno -> aluno.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos);
    }
}