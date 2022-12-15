package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Squirtle extends Pokemon {

    // "Squirtle", "Wartortle", "Blastoise"

    public Squirtle(){
        super("Squirtle", 0, 450);
        this.setEstagios(new String[]{"Psyduck", "Golduck"});
        this.setNomeDosGolpes(new String[][]{   {"Revólver d'Água", "Cauda de Água", "Rajada de Bolhas"},
                                                {"Hidro Bomba", "Quebra Crânio", "Raio de Gelo"},
                                                {"Revólver d'Água", "Jato d'Água", "Canhão Torrencial"}
                                            });
    }

    public Squirtle(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
