package com.grupo02;

import java.util.List;
import java.util.Random;

public abstract class Treinador {

    private String nome;
    private Integer nivel = 0;
    private List<Pokemon> pokemons;
    private Pokemon pokemonAtivo;
    private Integer pedraEvolucao = 0;
    private Boolean revive = true;

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
            System.out.printf("%d - %s\n", i + 1, pokemonAtivo.getNomeDosGolpes()[pokemonAtivo.getNivel()][i]);
        }
    }

    public void exibirListaPokemons() {
        int i = 1;
        for (Pokemon pokemon : this.pokemons) {
            System.out.printf("%d - %s \t| Pontos de vida: %d\n", i, pokemon.getNome(), pokemon.getPontosDeVida());
            i++;
        }
    }


    public void atacar(Treinador adversario, int ataque) {
        int dano = this.calcularDano(ataque);
        int pontosDeVidaPokemonAdversario = adversario.getPokemonAtivo().getPontosDeVida();
        if (dano > pontosDeVidaPokemonAdversario) {
            adversario.pokemonAtivo.setPontosDeVida(0);
            System.out.printf("O golpe %s do %s causou %d pontos de dano.\n",
                    this.getPokemonAtivo().getNomeDosGolpes()[this.getPokemonAtivo().getNivel()][ataque - 1],
                    this.getPokemonAtivo().getNome(), dano);
//            System.out.printf("O %s foi derrotado", adversario.getPokemonAtivo().getNome());
            return;
        }
//        System.out.println(adversario.getPokemonAtivo().getNome() + " perdeu " + dano + " pontos de vida");
        System.out.printf("O golpe %s do %s causou %d pontos de dano.\n",
                this.getPokemonAtivo().getNomeDosGolpes()[this.getPokemonAtivo().getNivel()][ataque - 1],
                this.getPokemonAtivo().getNome(), dano);
        adversario.pokemonAtivo.setPontosDeVida(adversario.getPokemonAtivo().getPontosDeVida() - dano);
    }

    public void curarPokemon() {
        if (!this.getRevive()) {
            return;
        }
        int pontosDeVidaAtual = this.getPokemonAtivo().getPontosDeVida();
        int pontosDeVidaRestaurados = (int) ((this.getPokemonAtivo().getVidaInicial() - pontosDeVidaAtual) * 0.75);
        this.getPokemonAtivo().setPontosDeVida(this.getPokemonAtivo().getPontosDeVida() + pontosDeVidaRestaurados);
        this.setRevive(false);
    }

    public Boolean evoluirPokemon(Pokemon pokemon) {
        if (this.getPedraEvolucao() == 0) {
            System.out.println("Você não tem a pedra da evolução.");
            System.out.println("Impossível evoluir o seu pokémon.");
            return false;
        }

        int nivelAtual = pokemon.getNivel();
        int nivelMaximo = pokemon.getEstagios().length - 1;
        if (nivelAtual < nivelMaximo) {
            switch (nivelAtual) {
                case 0:
                    pokemon.setNivel(nivelAtual + 1);
                    pokemon.setNome(pokemon.getEstagios()[1]);
                    pokemon.setVidaInicial(pokemon.getVidaInicial() + 100);
                    pokemon.setPontosDeVida(pokemon.getVidaInicial());
                    break;
                case 1:
                    pokemon.setNivel(nivelAtual + 1);
                    pokemon.setNome(pokemon.getEstagios()[2]);
                    pokemon.setVidaInicial(pokemon.getVidaInicial() + 150);
                    pokemon.setPontosDeVida(pokemon.getVidaInicial());
                    break;
            }
            this.setPedraEvolucao(this.getPedraEvolucao() - 1);
        } else {
            if (this instanceof Jogador) {
                System.out.println("Este pokémon já atingiu o máximo da evolução");
                System.out.println("Selecione outro pokémon para evoluir.");
                return false;
            }
        }
        return true;
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
        this.pokemonAtivo = pokemon;
//        if (pokemon.getPontosDeVida() != 0) {
//        }
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
}
