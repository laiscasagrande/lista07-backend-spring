package com.example.demo.exercicio03;


import java.time.LocalDate;
import java.util.UUID;

public class Tweet {
    private UUID tweetId;
    private String mensagem;
    private boolean editado;
    private LocalDate dataCriacao;

    Tweet(String mensagem, boolean editado) {
        this.tweetId = UUID.randomUUID();
        this.mensagem = mensagem;
        this.editado = editado;
        this.dataCriacao = LocalDate.now();
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public void setTweetId(UUID tweetId) {
        this.tweetId = tweetId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isEditado() {
        return editado;
    }

    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
