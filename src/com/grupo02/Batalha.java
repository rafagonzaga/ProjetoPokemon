package com.grupo02;

import com.grupo02.pokemons.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Pokemon> listaDePokemons = gerarListaDePokemons();

        exibirLogo();
        System.out.println("Seja bem-vindo à batalha de Pokémons");
        System.out.println("Escolha três pokémons para a batalha. Veja a lista de pokémons disponíveis:");
//        exibirTodosPokemons(listaDePokemons);
        List<Pokemon> pokemons = escolherPokemons(listaDePokemons, entrada);


        /*
        for (int i = 0; i < 3; i++) {
            System.out.printf("Escolha o %dº pokémon: ", i + 1);
            int escolha = entrada.nextInt();
            pokemons.add(listaDePokemons.get(escolha - 1));
            listaDePokemons.remove(escolha - 1);
            exibirTodosPokemons(listaDePokemons);
        }
        System.out.println("Lista final");
        exibirTodosPokemons(listaDePokemons);
        */

        Jogador rafael = new Jogador("Rafael", pokemons);
        Adversario npc1 = new Adversario("NPC1", listaDePokemons, "Vou te derrotar!");

        System.out.println("Agora vamos definir o seu pokémon para a batalha. Veja a sua lista: ");
        exibirTodosPokemons(rafael.getPokemons());
        System.out.print("Escolha o pokémon: ");

        int option = entrada.nextInt() - 1;
        rafael.setPokemonAtivo(rafael.getPokemons().get(option));
        npc1.setPokemonAtivo(npc1.getPokemons().get(new Random().nextInt(3)));
        System.out.println("Pokémon ativo: " + rafael.getPokemonAtivo());
        System.out.println("Pokémon ativo: " + npc1.getPokemonAtivo());
        rafael.getPokemonAtivo().setNivel(1);
        System.out.println("Os golpes do seu pokémon ativo são:");
        rafael.exibirListaGolpes(rafael.getPokemonAtivo());
        System.out.print("Escolha o golpe:");
        int ataque = entrada.nextInt();
        rafael.atacar(npc1, ataque);


        /*
        int ataque = 0;
        while (true){
            rafael.exibirListaGolpes(rafael.getPokemonAtivo());
            System.out.print("Escolha o gople que pretende usar: ");
            ataque = entrada.nextInt();
            rafael.atacar(npc1, ataque);
            verificaPokemon()
            npc1.atacar(rafael, new Random().nextInt(4) + 1);
            System.out.println(rafael.getPokemonAtivo().getPontosDeVida());
            System.out.println(npc1.getPokemonAtivo().getPontosDeVida());
            break;
        }
         */






        /*
        System.out.println(rafael.getPedraEvolucao());
        rafael.setPedraEvolucao(1);
        System.out.println(rafael.getPedraEvolucao());
        System.out.println(rafael.getRevive());

        Adversario npc1 = new Adversario("NPC1", pokemons, "Vou te derrotar!");
        System.out.println(npc1);
        System.out.println(npc1.getPokemons());

        rafael.exibirListaPokemons(pokemons);

        System.out.println(rafael.getPokemonAtivo());
//        rafael.setPokemonAtivo(charmander);

        while(rafael.getPokemonAtivo() == null || rafael.getPokemonAtivo().getPontosDeVida() == 0){
            System.out.println("Defina o seu pokemon para a batalha:");
            rafael.exibirListaPokemons(rafael.getPokemons());
//            int ativo = entrada.nextInt();
            int ativo = 1;
            rafael.setPokemonAtivo(rafael.getPokemons().get(ativo-1));

        }
        npc1.setPokemonAtivo(npc1.getPokemons().get(2));
        System.out.println(rafael.getPokemonAtivo());
        rafael.exibirListaGolpes(rafael.getPokemonAtivo());
        System.out.println();
        rafael.getPokemonAtivo().setNivel(2);
        rafael.exibirListaGolpes(rafael.getPokemonAtivo());

        System.out.println("DANO:");
        System.out.println(rafael.calcularDano(1));
        System.out.println(rafael.calcularDano(2));
        System.out.println(rafael.calcularDano(3));

        System.out.println(rafael.getPokemonAtivo());
        System.out.println(npc1.getPokemonAtivo());
        System.out.println(npc1.getPokemonAtivo().getPontosDeVida());

        rafael.atacar(npc1, 1);
        System.out.println(npc1.getPokemonAtivo().getNome() + " " + npc1.getPokemonAtivo().getPontosDeVida());
        npc1.atacar(rafael, 2);
        System.out.println(rafael.getPokemonAtivo().getNome() + " " + rafael.getPokemonAtivo().getPontosDeVida());
        rafael.atacar(npc1, 1);
        System.out.println(npc1.getPokemonAtivo().getNome() + " " + npc1.getPokemonAtivo().getPontosDeVida());
        rafael.atacar(npc1, 1);
        System.out.println(npc1.getPokemonAtivo().getPontosDeVida());
        */

        entrada.close();
    }

    public static List<Pokemon> gerarListaDePokemons(){
        Pokemon pikachu = new Pikachu();
        Pokemon charmander = new Charmander();
        Pokemon bulbasaur = new Bulbasaur();
        Pokemon squirtle = new Squirtle();
        Pokemon psyduck = new Psyduck();
        Pokemon jigglypuff = new Jigglypuff();
        Pokemon caterpie = new Caterpie();
        Pokemon pidgey = new Pidgey();
        Pokemon eevee = new Eevee();
        Pokemon weedle = new Weedle();
        Pokemon machop = new Machop();
        Pokemon voltorb = new Voltorb();

        List<Pokemon> listaDePokemons = new ArrayList<>() {{
            add(pikachu);
            add(charmander);
            add(bulbasaur);
            add(squirtle);
            add(psyduck);
            add(jigglypuff);
            add(caterpie);
            add(pidgey);
            add(eevee);
            add(weedle);
            add(machop);
            add(voltorb);
        }};
        return listaDePokemons;
    }

    private static void exibirLogo() {
        System.out.println("                                  ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|");
    }

    public static void exibirOpcoes() {
        System.out.println("O que deseja fazer:");
        System.out.println("1 - Definir um novo pokémon para a batalha:");
        System.out.println("2 - Curar ou reviver o seu pokémon");
        System.out.println("3 - Desistir do jogo");
    }

    public static void exibirTodosPokemons(List<Pokemon> pokemons) {
        int i = 1;
        for (Pokemon pokemon : pokemons) {
            System.out.printf("%d - %s\n", i, pokemon);
            i++;
        }
    }

    public static List<Pokemon> escolherPokemons(List<Pokemon> listaDePokemons, Scanner entrada){
        exibirTodosPokemons(listaDePokemons);

        List<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.printf("Escolha o %dº pokémon: ", i + 1);
            int escolha = entrada.nextInt();
            pokemons.add(listaDePokemons.get(escolha - 1));
            listaDePokemons.remove(escolha - 1);
            exibirTodosPokemons(listaDePokemons);
        }
        return pokemons;

    }public static List<Pokemon> escolherPokemonsNPC(List<Pokemon> listaDePokemons){
        List<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.printf("Escolha o %dº pokémon: ", i + 1);
//            int escolha = entrada.nextInt();
//            pokemons.add(listaDePokemons);
//            listaDePokemons.remove(escolha - 1);
        }
        return pokemons;
    }

    public static void batalhar(Treinador jogador, Treinador adversario) {

    }

}
