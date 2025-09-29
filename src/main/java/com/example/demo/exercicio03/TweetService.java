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

      //  tweets.add(new Tweet("Bom dia", true));
      //  tweets.add(new Tweet("Bom dia", true));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Tweet> getTweets(UUID usuarioId) {
        if (usuarioId == usuarios.get(0).getId()) {
            return tweets;
        }
        return null;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
