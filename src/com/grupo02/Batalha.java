package com.grupo02;

import com.grupo02.pokemons.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random rand = new Random();

        List<Pokemon> listaDePokemons = gerarListaDePokemons();

        exibirLogo();
        System.out.println("Seja bem-vindo à batalha de Pokémons");
        System.out.println("Escolha três pokémons para a batalha. Veja a lista de pokémons disponíveis:");
//        exibirTodosPokemons(listaDePokemons);
        List<Pokemon> pokemons = escolherPokemons(listaDePokemons, entrada);
        List<Pokemon> pokemonsNpc1 = escolherPokemonsNPC(listaDePokemons, rand);

        Jogador rafael = new Jogador("Rafael", pokemons);
        Adversario npc1 = new Adversario("NPC1", pokemonsNpc1, "Vou te derrotar!");
        System.out.println("Pokemons do adversário:");
        npc1.exibirListaPokemons();
        System.out.printf("%nLista de todos os pokemons restantes:%n");
        exibirTodosPokemons(listaDePokemons);
//        pokemons.add(new Pidgey());

        System.out.println("Agora vamos definir o seu pokémon para a batalha. Veja a sua lista: ");
        exibirTodosPokemons(rafael.getPokemons());
//        System.out.println();
        System.out.print("Escolha o pokémon: ");

        int option = entrada.nextInt() - 1;
        rafael.setPokemonAtivo(rafael.getPokemons().get(option));
        npc1.setPokemonAtivo(npc1.getPokemons().get(new Random().nextInt(3)));

        System.out.println("Pokémon ativo: " + rafael.getPokemonAtivo());
        System.out.println("Pokémon ativo: " + npc1.getPokemonAtivo());


        while (true) {
            /*
            System.out.println("Escolha o golpe:");
            System.out.println("Os golpes do seu pokémon ativo são:");
            rafael.exibirListaGolpes(rafael.getPokemonAtivo());
            int ataque = entrada.nextInt();
            rafael.atacar(npc1, ataque);
             */
            vezDoJogador(rafael, npc1, entrada);
            if (timeFoiDerrotado(npc1)) {
                System.out.println("Acabou a batalha. Você ganhou!");
                break;
            }
            verificaPokemonNpc(npc1);
            System.out.println("Agora é a vez do seu adversário");
            npc1.atacar(rafael, 3);
            if (timeFoiDerrotado(rafael)) {
                System.out.println("Acabou a batalha. Você perdeu!");
                break;
            }
            verificaPokemonJogador(rafael, entrada);
        }
        System.out.println("Fim de batalha");
        entrada.close();
    }

    public static List<Pokemon> gerarListaDePokemons() {
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

    public static void exibirOpcoes(Jogador jogador, Scanner entrada) {
        if (jogador.getPokemonAtivo().getPontosDeVida() == 0) {
            System.out.println("O que deseja fazer:");
            System.out.println("1 - Definir um novo pokémon para a batalha:");
            System.out.println("2 - Reviver o seu pokémon");
            switch (entrada.nextInt()) {
                case 1:
                    System.out.println("Qual será o seu próximo pokémon?");
//                    jogador.exibirListaPokemons();
                    while (jogador.getPokemonAtivo().getPontosDeVida() == 0) {
                        jogador.exibirListaPokemons();
                        jogador.setPokemonAtivo(jogador.getPokemons().get(entrada.nextInt() - 1));
                        if (jogador.getPokemonAtivo().getPontosDeVida() == 0) {
                            System.out.println("\nEste pokémon não pode ser escolhido.");
                            System.out.println("Escolha um outro pokémon.\n");
                        }
                    }
                    break;
                case 2:
                    jogador.exibirListaPokemons();
                    jogador.setPokemonAtivo(jogador.getPokemons().get(entrada.nextInt() - 1));
                    while (jogador.getPokemonAtivo().getPontosDeVida() != 0) {
                        System.out.println("\nEste pokémon não pode ser revivido.");
                        System.out.println("Escolha outro pokémon para reviver.\n");
                        jogador.exibirListaPokemons();
                        jogador.setPokemonAtivo(jogador.getPokemons().get(entrada.nextInt() - 1));
                    }
                    jogador.getPokemonAtivo().setPontosDeVida(jogador.getPokemonAtivo().getVidaInicial());
                    System.out.println("Revivendo o pokémon...");
                    System.out.println("O seu pokémon tem agora: " + jogador.getPokemonAtivo().getPontosDeVida());
                    jogador.setRevive(false);
                    break;
            }
        }
    }


    public static void exibirTodosPokemons(List<Pokemon> pokemons) {
        int i = 1;
        for (Pokemon pokemon : pokemons) {
            if (pokemons.size() <= 3) {
                System.out.printf("%d - %-10s\n", i, pokemon);
                i++;
            } else {
                if ((i - 1) % 2 == 0 && i != 2) {
                    System.out.println();
                }
                System.out.printf("%d - %-10s", i, pokemon);
                System.out.printf("\t\t");
                i++;
            }
        }
        System.out.println();
    }

    public static List<Pokemon> escolherPokemons(List<Pokemon> listaDePokemons, Scanner entrada) {
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

    }

    public static List<Pokemon> escolherPokemonsNPC(List<Pokemon> listaDePokemons, Random rand) {
        List<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int escolhaAleatoria;
            escolhaAleatoria = rand.nextInt(listaDePokemons.size()) + 1;
            pokemons.add(listaDePokemons.get(escolhaAleatoria - 1));
            listaDePokemons.remove((escolhaAleatoria - 1));
        }
//        System.out.printf("Escolhi esses pokemons: ", i + 1);
        return pokemons;
    }

    public static void verificaPokemonJogador(Jogador jogador, Scanner entrada) {
        Pokemon pokemonAtivo = jogador.getPokemonAtivo();
        if (pokemonAtivo.getPontosDeVida() == 0) {
            System.out.printf("O seu %s foi derrotado.%n", pokemonAtivo.getNome());
            exibirOpcoes(jogador, entrada);
        }
//            return entrada.nextInt();

//        return null;
    }

    public static void verificaPokemonNpc(Treinador adversario) {
        Pokemon pokemonAtivo = adversario.getPokemonAtivo();
        if (pokemonAtivo.getPontosDeVida() == 0) {
            System.out.printf("O seu %s foi derrotado.%n", pokemonAtivo.getNome());
        }
        while (adversario.getPokemonAtivo().getPontosDeVida() == 0) {
            int escolha = new Random().nextInt(3);
            adversario.setPokemonAtivo(adversario.getPokemons().get(escolha));
        }
        System.out.println("O pokémon ativo do adversário é:" + adversario.getPokemonAtivo().getNome());
//            return entrada.nextInt();

//        return null;
    }

    public static boolean timeFoiDerrotado(Treinador treinador) {
        int totalPontosDeVidaDoTime = 0;
        for (Pokemon pokemon : treinador.getPokemons()) {
            totalPontosDeVidaDoTime += pokemon.getPontosDeVida();
        }
        return totalPontosDeVidaDoTime == 0;
    }

    public static void vezDoJogador(Jogador jogador, Adversario adversario, Scanner entrada) {
        if (jogador.getPokemonAtivo().getPontosDeVida() < jogador.getPokemonAtivo().getVidaInicial() &&
                jogador.getRevive()) {
            System.out.println("Sua vez. Agora você pode:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Curar o seu pokémon");
            System.out.print("O que você quer fazer? ");
            int escolha = entrada.nextInt();
            if (escolha == 1) {
                System.out.println("Escolha o golpe:");
                System.out.println("Os golpes do seu pokémon ativo são:");
                jogador.exibirListaGolpes(jogador.getPokemonAtivo());
                int ataque = entrada.nextInt();
                jogador.atacar(adversario, ataque);
            } else if (escolha == 2) {
                System.out.println("Curando o pokemon...");
                jogador.curarPokemon();
                System.out.printf("O %s foi curado e agora tem %d pontos de vida",
                        jogador.getPokemonAtivo().getNome(), jogador.getPokemonAtivo().getPontosDeVida());
            }
        } else {
            System.out.println("Sua vez. Agora você pode:");
            System.out.println("1 - Atacar");
            System.out.print("O que você quer fazer? ");
            int escolha = entrada.nextInt();
            if (escolha == 1) {
                System.out.println("Escolha o golpe:");
                System.out.println("Os golpes do seu pokémon ativo são:");
                jogador.exibirListaGolpes(jogador.getPokemonAtivo());
                System.out.print("Como quer atacar? ");
                int ataque = entrada.nextInt();
                jogador.atacar(adversario, ataque);
            }
        }
    }

    public static void batalhar(Treinador jogador, Treinador adversario) {

    }

}
