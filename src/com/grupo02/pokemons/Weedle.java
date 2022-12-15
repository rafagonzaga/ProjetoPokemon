package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Weedle extends Pokemon {

    // "Weedle", "Kakuna", "Beedrill"

    public Weedle(){
        super("Weedle", 0, 450);
        this.setEstagios(new String[]{"Weedle", "Kakuna", "Beedrill"});
        this.setNomeDosGolpes(new String[][]{   {"Tiro de Estilingue", "Picada", "Ferroada Venenosa"},
                                                {"Jato de Seda", "Picada Venenosa", "Arremesso de Teia"},
                                                {"Ataque Supersônico", "Bomba de Lodo", "Enxame de Ferrão"}
                                            });
    }

    public Weedle(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
