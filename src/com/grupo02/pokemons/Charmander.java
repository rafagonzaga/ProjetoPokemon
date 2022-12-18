package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Charmander extends Pokemon {

    private Integer hpInicial = 450;
    // "Charmander", "Charmeleon", "Charizard"

    public Charmander(){
        super("Charmander", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Charmander", "Charmeleon", "Charizard"});
        this.setNomeDosGolpes(new String[][]{   {"Rosnar", "Brasas", "Lança-Chamas"},
                                                {"Arranhar", "Cabeçada", "Lança-Chamas"},
                                                {"Incinerar", "Explosão de Fogo", "Incêndio Astral"}
                                            });
    }

    public Charmander(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

}
