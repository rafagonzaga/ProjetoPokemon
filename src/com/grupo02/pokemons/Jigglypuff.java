package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Jigglypuff extends Pokemon {

    // "Jigglypuff", "Wigglytuff"

    public Jigglypuff(){
        super("Jigglypuff", 0, 520);
        this.setEstagios(new String[]{"Jigglypuff", "Wigglytuff"});
        this.setNomeDosGolpes(new String[][]{   {"Confusão", "Pulso d'Água", "Hidro Bomba"},
                                                {"Explosão Focalizada", "Hidro Bomba", "Aqua-Míssil"}
                                            });
    }

    public Jigglypuff(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
