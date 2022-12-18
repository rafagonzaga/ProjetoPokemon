package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Jigglypuff extends Pokemon {

    private Integer hpInicial = 520;
    // "Jigglypuff", "Wigglytuff"

    public Jigglypuff(){
        super("Jigglypuff",0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Jigglypuff", "Wigglytuff"});
        this.setNomeDosGolpes(new String[][]{   {"Confusão", "Pulso d'Água", "Hidro Bomba"},
                                                {"Explosão Focalizada", "Hidro Bomba", "Aqua-Míssil"}
                                            });
    }

    public Jigglypuff(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

}
