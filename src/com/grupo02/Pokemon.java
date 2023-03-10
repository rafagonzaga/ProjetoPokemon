package com.grupo02;

public class Pokemon {

    private String nome;
    private Integer nivel;
    private Integer vidaInicial;
    private Integer pontosDeVida;
    private String[][] nomeDosGolpes;
    private String[] estagios;

    public Pokemon(String nome, Integer nivel, Integer pontosDeVida) {
        this.nome = nome;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
    }

    public Pokemon(String nome, Integer nivel){
        this.nome = nome;
        this.nivel = nivel;
    }

    public Integer getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(Integer pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public Integer getVidaInicial() {
        return vidaInicial;
    }

    public void setVidaInicial(Integer vidaInicial) {
        this.vidaInicial = vidaInicial;
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

    public String[] getEstagios() {
        return estagios;
    }

    public void setEstagios(String[] estagios) {
        this.estagios = estagios;
    }

    public String toString() {
        return this.getNome() + " - Evolução: " + this.getNivel();
    }
}
