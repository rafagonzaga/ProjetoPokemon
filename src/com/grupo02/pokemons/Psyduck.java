package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Psyduck extends Pokemon {

    private Integer hpInicial = 510;
    // "Psyduck", "Golduck"

    public Psyduck(){
        super("Psyduck", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
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
