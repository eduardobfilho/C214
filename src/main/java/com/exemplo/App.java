package com.exemplo;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Objeto exemplo = new Objeto("Olá", 42);
        String json = gson.toJson(exemplo);
        System.out.println(json);
    }

    static class Objeto {
        String mensagem;
        int numero;

        public Objeto(String mensagem, int numero) {
            this.mensagem = mensagem;
            this.numero = numero;
        }
    }
}