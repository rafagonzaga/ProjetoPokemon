package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Voltorb extends Pokemon {

    private Integer hpInicial = 500;
    // "Voltorb", "Electronode"

    public Voltorb(){
        super("Voltorb", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Voltorb", "Electronode"});
        this.setNomeDosGolpes(new String[][]{   {"Relâmpago", "Faísca", "Choque Elétrico"},
                                                {"Raio Carregado Ondulante", "Canhão Elétrico", "Descarga"}
                                            });
    }

    public Voltorb(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
