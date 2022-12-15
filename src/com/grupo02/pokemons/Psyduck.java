package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Psyduck extends Pokemon {

    // "Psyduck", "Golduck"

    public Psyduck(){
        super("Psyduck", 0, 520);
        this.setEstagios(new String[]{"Psyduck", "Golduck"});
        this.setNomeDosGolpes(new String[][]{   {"Confusão", "Pulso d'Água", "Hidro Bomba"},
                                                {"Explosão Focalizada", "Hidro Bomba", "Aqua-Míssil"}
                                            });
    }

    public Psyduck(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
