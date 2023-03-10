package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Caterpie extends Pokemon {

    private Integer hpInicial = 480;
    // "Caterpie", "Metapod", "Butterfree"

    public Caterpie(){
        super("Caterpie", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Caterpie", "Metapod", "Butterfree"});
        this.setNomeDosGolpes(new String[][]{   {"Picada", "Investida", "Tiro de Estilingue"},
                                                {"Ariete", "Investida", "Tiro de Estilingue"},
                                                {"Lufada de Vento", "Confusão","Pó Venenoso"}
                                            });
    }

    public Caterpie(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

}
