package com.grupo02;

import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    private String nome;
    private Integer nivel;
    private Integer pontosDeVida;
    private String[][] nomeDosGolpes;
    private String[] estagios;

    Map<Integer, String[]> ataquesPorNivel = new HashMap<>();


    public Pokemon(String nome, Integer nivel, Integer pontosDeVida) {
        this.nome = nome;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
//        ataquesPorNivel.put(1, new String[]{"Spark", "Thunder Shock", "Discharge"});
//        ataquesPorNivel.put(2, new String[]{"Spark", "Thunder Shock", "Thunder"});
//        ataquesPorNivel.put(3, new String[]{"Spark", "Thunder Shock", "Thunderbolt"});
    }

    public Integer getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(Integer pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String[][] getNomeDosGolpes() {
        return nomeDosGolpes;
    }

    public void setNomeDosGolpes(String[][] nomeDosGolpes) {
        this.nomeDosGolpes = nomeDosGolpes;
    }

    public Map<Integer, String[]> getAtaquesPorNivel() {
        return ataquesPorNivel;
    }

    public void setAtaquesPorNivel(Map<Integer, String[]> ataquesPorNivel) {
        this.ataquesPorNivel = ataquesPorNivel;
    }

    public String[] getEstagios() {
        return estagios;
    }

    public void setEstagios(String[] estagios) {
        this.estagios = estagios;
    }
}
