package com.example.demo.exercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TweetService {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Tweet> tweets = new ArrayList<>();

    public TweetService() {
        usuarios.add(new Usuario("Laís", "laiskaminski750@gmail.com"));
        usuarios.add(new Usuario("Jaqueline", "jaqueline@gmail.com"));
        usuarios.add(new Usuario("Beatriz", "beatriz750@gmail.com"));
        usuarios.add(new Usuario("Lucas", "lucas750@gmail.com"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Tweet> getTweetsById(UUID usuarioId) {
        if (usuarioId == usuarios.get(0).getId()) {
            return tweets;
        }
        return null;
    }

    public Tweet setTweets(Tweet tweet, UUID id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                Tweet novoTweet = new Tweet(tweet.getMensagem(), false);
                usuario.getTweets().add(novoTweet);
                return novoTweet;
            }
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public Tweet atualizaMensagem(Tweet tweet, UUID id, UUID tweetId) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                for (Tweet novoTweet : usuario.getTweets()) {
                    if (novoTweet.getTweetId().equals(tweetId)) {
                        novoTweet.setMensagem(tweet.getMensagem());
                        novoTweet.setEditado(true);
                        return novoTweet;
                    }
                }
                throw new RuntimeException("Tweet não encontrado");
            }
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public void removerTweet(UUID id, UUID tweetId) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.getTweets().removeIf(novoTweet -> novoTweet.getTweetId().equals(tweetId));
            }
        }
    }
}
