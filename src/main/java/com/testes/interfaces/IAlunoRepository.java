package com.testes.interfaces;

import com.testes.entities.Aluno;

public interface IAlunoRepository {
    Aluno buscarPorMatricula(String matricula);

    void salvar(Aluno aluno);
}