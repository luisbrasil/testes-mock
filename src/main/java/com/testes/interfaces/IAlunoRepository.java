package com.testes.interfaces;

import java.util.List;

import com.testes.entities.Aluno;

public interface IAlunoRepository {
    Aluno buscarPorMatricula(String matricula);
    List<Aluno> listarTodos();
    void salvar(Aluno aluno);
}