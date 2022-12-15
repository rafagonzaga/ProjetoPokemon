package com.grupo02;

import java.util.List;
import java.util.Random;

public abstract class Treinador {

    private String nome;
    private Integer nivel = 0;
    private List<Pokemon> pokemons;
    private Pokemon pokemonAtivo;

    public Treinador(String nome, List<Pokemon> pokemons) {
        this.nome = nome;
        this.pokemons = pokemons;
    }

    public Treinador(String nome, Integer nivel, List<Pokemon> pokemons) {
        this.nome = nome;
        this.nivel = nivel;
        this.pokemons = pokemons;
    }

    public void exibirListaGolpes(Pokemon pokemonAtivo) {

        for (int i = 0; i < pokemonAtivo.getNomeDosGolpes()[1].length; i++) {
//            System.out.println(i + pokemonAtivo.getNomeDosGolpes()[nivel][i]);
            System.out.printf("%d - %s\n", i+1 , pokemonAtivo.getNomeDosGolpes()[pokemonAtivo.getNivel()][i]);
        }
    }

    public void exibirListaPokemons(List<Pokemon> pokemons) {
        int i = 1;
        for(Pokemon pokemon : pokemons){
            System.out.printf("%d - %s \t| Pontos de vida: %d\n", i, pokemon, pokemon.getPontosDeVida());
            i++;
        }
    }


    public void atacar(Treinador adversario, int ataque) {
        int dano = this.calcularDano(ataque);
        int pontosDeVidaPokemonAdversario = adversario.getPokemonAtivo().getPontosDeVida();
        if (dano > pontosDeVidaPokemonAdversario) {
            adversario.pokemonAtivo.setPontosDeVida(0);
            System.out.println(adversario.getPokemonAtivo().getNome() + " foi derrotado");
            return;
        }
        System.out.println(adversario.getPokemonAtivo().getNome() + " perdeu " + dano + " pontos de vida");
        adversario.pokemonAtivo.setPontosDeVida(adversario.getPokemonAtivo().getPontosDeVida() - dano);
    }

    public void verificaPokemon(Treinador treinador){
        Pokemon pokemonAtivo = treinador.getPokemonAtivo();
        if(pokemonAtivo.getPontosDeVida() == 0){
        }
    }

    public Integer calcularDano(int ataque) {
        Random rand = new Random();
        int dano = 0;
        int danoBalanceado;
        int nivelPokemom = pokemonAtivo.getNivel();

        if (nivelPokemom == 0) {
            danoBalanceado = rand.nextInt(20);
            switch (ataque) {
                case 1:
                    dano = 100 + danoBalanceado;
                    break;
                case 2:
                    dano = 110 + danoBalanceado;
                    break;
                case 3:
                    dano = 120 + danoBalanceado;
                    break;
            }
        } else if (nivelPokemom == 1) {
            danoBalanceado = rand.nextInt(30);
            switch (ataque) {
                case 1:
                    dano = 125 + danoBalanceado;
                    break;
                case 2:
                    dano = 135 + danoBalanceado;
                    break;
                case 3:
                    dano = 145 + danoBalanceado;
                    break;
            }
        } else if (nivelPokemom == 2) {
            danoBalanceado = rand.nextInt(40);
            switch (ataque) {
                case 1:
                    dano = 150 + danoBalanceado;
                    break;
                case 2:
                    dano = 160 + danoBalanceado;
                    break;
                case 3:
                    dano = 170 + danoBalanceado;
                    break;
            }
        }
        return dano;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon getPokemonAtivo() {
        return pokemonAtivo;
    }

    public void setPokemonAtivo(Pokemon pokemon) {
        if (pokemon.getPontosDeVida() == 0) {
            System.out.println("Este pokemon não pode ser escolhido.");
        } else {
            this.pokemonAtivo = pokemon;
        }
    }
}
