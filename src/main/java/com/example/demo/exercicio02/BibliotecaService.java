package com.example.demo.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private final List<Livro> livrosDisponiveis = new ArrayList<>(); //o final torna a referência da variável imutável, depois de inicializada, não pode ser alterada
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public BibliotecaService() { //aqui é o serviço para realizar as operações
        livrosDisponiveis.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        livrosDisponiveis.add(new Livro("Harry Potter", "J.K. Rowling"));
        livrosDisponiveis.add(new Livro("1984", "George Orwell"));
    }
}
