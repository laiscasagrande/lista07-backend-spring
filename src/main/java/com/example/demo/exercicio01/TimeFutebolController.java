package com.example.demo.exercicio01;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação @GetMapping, usada para mapear requisições HTTP GET
import org.springframework.web.bind.annotation.PutMapping; // Importa a anotação @PutMapping, usada para mapear requisições HTTP PUT
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação @PathVariable, que permite receber valores da URL como parâmetro
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação @RequestMapping, usada para definir o caminho base da API
import org.springframework.web.bind.annotation.RestController; // Importa a anotação @RestController, que transforma esta classe em um controller REST

@RestController //esta classe é um ocntrolador Rest
@RequestMapping("/api/time") //caminho base para todos os endpoints
public class TimeFutebolController {

    private final TimeService timeService; // serviço que contém a lógica do time

    @GetMapping
    public String home() {
        return "API online.";
    }

    // Injeção de dependência via construtor
    public TimeFutebolController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/principal") // GET /api/time/principal
    public List<Jogador> exibeTitulares() { //vai listar os jogadores titulares
        return timeService.getTitulares();
    }

    @GetMapping("/reservas") // GET /api/time/reservas
    public List<Jogador> exibeReservas() { //vai listar os jogadores reservas
        return timeService.getReservas();
    }

    @PutMapping("/jogador/{posicao}") // PUT /api/time/jogador/{posicao}
    public String substituir(@PathVariable int posicao) { //substitui o jogador da posição informada
        return timeService.substituirJogador(posicao);
    }

}
