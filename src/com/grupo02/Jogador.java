package com.grupo02;

import java.util.List;

public class Jogador extends Treinador {

//    private List<Pokemon> pokemons;


    // Construtor para o jogador
    public Jogador(String nome, List<Pokemon> pokemons) {
        super(nome, pokemons);
//        this.pokemons = pokemons;
    }

    public Jogador(String nome, List<Pokemon> pokemons, Integer nivel){
        super(nome, nivel, pokemons);
        this.setPedraEvolucao(0);
        this.setRevive(false);
    }





    @Override
    public String toString() {
        return "Jogador{" +
                " Nome=" + this.getNome() +
                " Nível=" + this.getNivel() +
                " pokemons=" + this.getPokemons() +
                '}';
    }
}
