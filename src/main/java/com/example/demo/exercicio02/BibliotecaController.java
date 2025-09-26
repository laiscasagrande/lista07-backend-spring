package com.example.demo.exercicio02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {
    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping("/livros")
    public List<Livro> exibeLivros() {
        return bibliotecaService.getLivrosDisponiveis();
    }

    @GetMapping("/emprestados")
    public List<Emprestimo> exibeReservas() {
        return bibliotecaService.getEmprestimos();
    }

    @PostMapping("/emprestados/{id}/{usuarioId}")
    public Emprestimo criarEmprestimo(UUID id, String usuarioId) {
        return bibliotecaService.criarEmprestimo(id, usuarioId);
    }

    @DeleteMapping("/emprestados/{emprestimoId}")
    public void removerEmprestimo(UUID emprestimoId) {
        bibliotecaService.removerEmprestimo(emprestimoId);
    }
}
