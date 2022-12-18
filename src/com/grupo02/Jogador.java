package com.grupo02;

import java.util.List;

public class Jogador extends Treinador {

    // Construtor para o jogador
    public Jogador(String nome, List<Pokemon> pokemons) {
        super(nome, pokemons);
    }

    public Jogador(String nome, List<Pokemon> pokemons, Integer nivel){
        super(nome, nivel, pokemons);
        this.setPedraEvolucao(0);
        this.setRevive(false);
    }

    public void recupearPontosDeVidaEquipe(){
        for(Pokemon pokemon : this.getPokemons()){
            pokemon.setPontosDeVida(pokemon.getVidaInicial());
        }
        this.setPedraEvolucao(this.getPedraEvolucao()+1);
        this.setRevive(true);
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
