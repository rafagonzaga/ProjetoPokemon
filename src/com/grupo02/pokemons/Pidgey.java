package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Pidgey extends Pokemon {

    private Integer hpInicial = 480;
    // "Pidgey", "Pidgeotto", "Pidgeot"

    public Pidgey(){
        super("Pidgey", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Pidgey", "Pidgeotto", "Pidgeot"});
        this.setNomeDosGolpes(new String[][]{   {"Ventania", "Ataque de Asa", "Bicada"},
                                                {"Golpe Aéreo", "Corte Duplo", "Rajada de Vento"},
                                                {"Ás Aéreo", "Ataque Rápido","Surf Aéreo"}
                                            });
    }

    public Pidgey(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

}
