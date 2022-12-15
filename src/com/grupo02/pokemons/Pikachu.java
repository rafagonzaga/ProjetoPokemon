package com.grupo02.pokemons;

import com.grupo02.Pokemon;

public class Pikachu extends Pokemon {

    // "Pikachu", "Raichu"

    public Pikachu(){
        super("Pikachu", 0, 500);
        this.setEstagios(new String[]{"Pikachu", "Raichu"});
        this.setNomeDosGolpes(new String[][]{   {"Ataque rápido", "Cauda de Ferro", "Investida Trovão"},
                                                {"Trovoada de choques", "Ataque Relâmpago", "Bola Elétrica"}
                                            });

    }

    public Pikachu(String nome, Integer nivel, Integer pontosDeVida) {
        super(nome, nivel, pontosDeVida);
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
