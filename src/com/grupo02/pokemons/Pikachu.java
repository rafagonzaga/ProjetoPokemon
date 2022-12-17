package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Pikachu extends Pokemon {

    // "Pikachu", "Raichu"

    private Integer hpInicial = 500;


    public Pikachu() {
        super("Pikachu", 0);
        this.setVidaInicial(hpInicial);
        this.setPontosDeVida(hpInicial);
        this.setEstagios(new String[]{"Pikachu", "Raichu"});
        this.setNomeDosGolpes(new String[][]{   {"Ataque rápido", "Cauda de Ferro", "Investida Trovão"},
                                                {"Trovoada de choques", "Ataque Relâmpago", "Bola Elétrica"}
                                            });

    }

    public Pikachu(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    /*
        public Integer getVidaInicial() {
            return vidaInicial;
        }

        public void setVidaInicial(Integer vidaInicial) {
            this.vidaInicial = vidaInicial;
        }
    */
    @Override
    public String toString() {
        return this.getNome();
    }

}
