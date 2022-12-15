package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Caterpie extends Pokemon {

    // "Caterpie", "Metapod", "Butterfree"

    public Caterpie(){
        super("Caterpie", 0, 480);
        this.setEstagios(new String[]{"Caterpie", "Metapod", "Butterfree"});
        this.setNomeDosGolpes(new String[][]{   {"Picada", "Investida", "Tiro de Estilingue"},
                                                {"Ariete", "Investida", "Tiro de Estilingue"},
                                                {"Lufada de Vento", "Confusão","Pó Venenoso"}
                                            });
    }

    public Caterpie(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
