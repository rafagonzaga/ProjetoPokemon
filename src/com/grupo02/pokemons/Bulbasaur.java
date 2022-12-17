package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Bulbasaur extends Pokemon {

    private Integer hpInicial = 480;
    // "Bulbasaur", "Ivysaur", "Venusaur"

    public Bulbasaur(){
        super("Bulbasaur", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Bulbasaur", "Ivysaur", "Venusaur"});
        this.setNomeDosGolpes(new String[][]{   {"Esfera de Energia", "Semente Sanguessuga", "Folha Navalha"},
                                                {"Deslize de Grama", "Bala de Sementes", "Corte Duplo"},
                                                {"Raio Solar", "Fúria das Plantas", "Nevasca de Pétalas"}
                                            });
    }

    public Bulbasaur(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
