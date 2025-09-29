package com.example.demo.exercicio03;

import com.example.demo.exercicio02.Emprestimo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TweetController {
    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> exibeUsuarios() {
        return tweetService.getUsuarios();
    }

    @GetMapping("/usuarios/{id}/tweets")
    public List<Tweet> exibeTweetsDoUsuario(@PathVariable UUID id) {
        return tweetService.getTweetsById(id);
    }

    @PostMapping("/usuarios/{id}/tweets")
    public Tweet criarTweet(@RequestBody Tweet tweet, @PathVariable UUID id) {
        return tweetService.setTweets(tweet, id);
    }

    @PatchMapping("/usuarios/{id}/tweets/{tweetId}")
    public Tweet atualizarMensagem(@RequestBody Tweet tweet, @PathVariable UUID id, @PathVariable UUID tweetId){
        return tweetService.atualizaMensagem(tweet, tweetId, id);
    }

    @DeleteMapping("/usuarios/{id}/tweets/{tweetId}")
    public void removerTweet(@PathVariable UUID id, @PathVariable UUID tweetId) {
        tweetService.removerTweet(id, tweetId);
    }
}
