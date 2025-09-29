package com.example.demo.exercicio01;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {
    private final List<Jogador> jogadores = new ArrayList<>(); //cria uma lista de jogadores através da classe Jogador

    public TimeService() { //metodo construtor
        for (int i = 0; i < 11; i++) {
            jogadores.add(new Jogador("Titular " + i, "Posição " + i, 20 + i));
        }
        for (int i = 11; i < 16; i++) {
            jogadores.add(new Jogador("Reserva " + i, "Posição " + i, 20 + i));
        }
    }

    public List<Jogador> getTitulares() { //para listar os jogadores titulares
        return jogadores.subList(0, 11);
    }

    public List<Jogador> getReservas() { //para listar os jogadores reservas
        return jogadores.subList(11, jogadores.size());
    }

    public String substituirJogador(int posicao) { //para substituir o jogador
        if (posicao < 0 || posicao >= 11) return "Posição inválida (0–10).";
        if (getReservas().isEmpty()) return "Não há mais reservas.";

        Jogador reserva = getReservas().remove(0);
        Jogador titular = jogadores.set(posicao, reserva);
        jogadores.add(titular);

        return titular.getNome() + " saiu, " + reserva.getNome() + " entrou.";
    }
}
