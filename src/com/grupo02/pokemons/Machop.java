package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Machop extends Pokemon {

    // "Machop", "Machoke", "Machamp"

    public Machop(){
        super("Machop", 0, 450);
        this.setEstagios(new String[]{"Machop", "Machoke", "Machamp"});
        this.setNomeDosGolpes(new String[][]{   {"Soco", "Golpe Cruzado", "Batida de Pedra"},
                                                {"Força", "Arremesso Sísmico", "Explosão Focalizada"},
                                                {"Golpe Cruzado", "Laço Corpulento", "Soco Dinamite"}
                                            });
    }

    public Machop(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
