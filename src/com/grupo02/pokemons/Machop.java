package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Machop extends Pokemon {

    private Integer hpInicial = 450;
    // "Machop", "Machoke", "Machamp"

    public Machop(){
        super("Machop", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Machop", "Machoke", "Machamp"});
        this.setNomeDosGolpes(new String[][]{   {"Soco", "Golpe Cruzado", "Batida de Pedra"},
                                                {"Força", "Arremesso Sísmico", "Explosão Focalizada"},
                                                {"Golpe Cruzado", "Laço Corpulento", "Soco Dinamite"}
                                            });
    }

    public Machop(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

}
