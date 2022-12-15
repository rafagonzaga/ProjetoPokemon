package com.grupo02;

import java.util.List;

public class Jogador extends Treinador {

//    private List<Pokemon> pokemons;
    private Integer pedraEvolucao = 0;
    private Boolean revive = true;

    // Construtor para o jogador
    public Jogador(String nome, List<Pokemon> pokemons) {
        super(nome, pokemons);
//        this.pokemons = pokemons;
    }

    public Jogador(String nome, List<Pokemon> pokemons, Integer nivel){
        super(nome, nivel, pokemons);
    }



    public Integer getPedraEvolucao() {
        return pedraEvolucao;
    }

    public void setPedraEvolucao(Integer pedraEvolucao) {
        this.pedraEvolucao = pedraEvolucao;
    }

    public Boolean getRevive() {
        return revive;
    }

    public void setRevive(Boolean revive) {
        this.revive = revive;
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
