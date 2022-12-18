package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Squirtle extends Pokemon {

    private Integer hpInicial = 475;
    // "Squirtle", "Wartortle", "Blastoise"

    public Squirtle(){
        super("Squirtle", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Psyduck", "Golduck"});
        this.setNomeDosGolpes(new String[][]{   {"Revólver d'Água", "Cauda de Água", "Rajada de Bolhas"},
                                                {"Hidro Bomba", "Quebra Crânio", "Raio de Gelo"},
                                                {"Revólver d'Água", "Jato d'Água", "Canhão Torrencial"}
                                            });
    }

    public Squirtle(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

}
