package com.example.demo.exercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BibliotecaService {
    private final List<Livro> livrosDisponiveis = new ArrayList<>(); //o final torna a referência da variável imutável, depois de inicializada, não pode ser alterada
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public BibliotecaService() { //aqui é o serviço para realizar as operações
        livrosDisponiveis.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        livrosDisponiveis.add(new Livro("Harry Potter", "J.K. Rowling"));
        livrosDisponiveis.add(new Livro("1984", "George Orwell"));
    }

    public List<Livro> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Emprestimo criarEmprestimo(UUID id, String usuarioId){
        Livro livroEncontrado = null;
        for (Livro l : livrosDisponiveis) {
            if (l.getId().equals(id)) {
                livroEncontrado = l;
                break;
            }
        }

        if (livroEncontrado == null) {
            throw new RuntimeException("Livro não disponível");
        }

        Emprestimo emprestimo = new Emprestimo(livroEncontrado, usuarioId);

        livrosDisponiveis.removeIf(livro -> livro.getId().equals(id));

        emprestimos.add(emprestimo);

        return emprestimo;
    }

    public void removerEmprestimo(UUID emprestimoId){
        Emprestimo livroDevolvido = null;

        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getEmprestimoId().equals(emprestimoId)){ //se o id do emprestimo que foi executado é igual ao id do emprestimo que estou querendo desfazer(no caso devolver o livro)
                livroDevolvido = emprestimo;
                break;
            }
        }

        if (livroDevolvido == null){
            throw new RuntimeException("Empréstimo não encontrado");
        }

        emprestimos.remove(livroDevolvido);

        livrosDisponiveis.add(livroDevolvido.getLivro());
    }
}
