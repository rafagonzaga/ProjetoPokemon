package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Eevee extends Pokemon {

    // "Eevee", "Vaporeon"

    public Eevee(){
        super("Eevee", 0, 480);
        this.setEstagios(new String[]{"Eevee", "Vaporeon"});
        this.setNomeDosGolpes(new String[][]{   {"Investida", "Mordida", "Surra de Cauda"},
                                                {"Jato d'Água", "Pulo Borrifante", "Dilúvio Max"}
                                            });
    }

    public Eevee(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
