package com.example.demo.exercicio02;
import java.util.UUID;
import java.time.LocalDateTime;

public class Emprestimo {
    private UUID emprestimoId;
    private UUID livroId;
    private String usuarioId;
    private LocalDateTime dataEmprestimo;

    public Emprestimo(UUID livroId, String usuarioId) {
        this.emprestimoId = UUID.randomUUID();
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataEmprestimo = LocalDateTime.now();
    }

    // Getters e setters
    public UUID getEmprestimoId() {
        return emprestimoId;
    }
    public UUID getLivroId() {
        return livroId;
    }
    public String getUsuarioId() {
        return usuarioId;
    }
    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }
}
