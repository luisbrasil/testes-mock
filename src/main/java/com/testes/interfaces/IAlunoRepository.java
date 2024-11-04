package main.java.com.testes.interfaces;

import main.java.com.testes.entities.Aluno;

public interface IAlunoRepository {
    Aluno buscarPorMatricula(String matricula);

    void salvar(Aluno aluno);
}