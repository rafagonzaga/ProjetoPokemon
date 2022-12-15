package com.grupo02;

import java.util.List;

public class Adversario extends Treinador {

    private List<Pokemon> pokemons;
    private String fraseDeEfeito;


    public Adversario(String nome, List<Pokemon> pokemons, String fraseDeEfeito) {
        super(nome, pokemons);
        this.fraseDeEfeito = fraseDeEfeito;
    }

    public String getFraseDeEfeito() {
        return fraseDeEfeito;
    }

    public void setFraseDeEfeito(String fraseDeEfeito) {
        this.fraseDeEfeito = fraseDeEfeito;
    }

    @Override
    public String toString() {
        return "Adversario{" +
                " Nome=" + this.getNome() +
                " Frase de efeito=" + this.fraseDeEfeito +
                " pokemons=" + this.getPokemons().toString() +
                '}';
    }

    public void definirPokemonAtivo(List<Pokemon> pokemons) {

    }
}
