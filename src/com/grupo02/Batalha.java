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
        System.out.print("Digite o seu nome para se tornar um treinador de pokémon: ");
        String name = entrada.nextLine();
        System.out.printf("Ótimo, %s.\n", name);
        System.out.println("Agora você precisa escolher três pokémons para a batalha.");
        System.out.println("Veja a lista de pokémons disponíveis:");
        List<Pokemon> pokemons = escolherPokemons(listaDePokemons, entrada);
        List<Adversario> listaNpcs = gerarListaNPCS(listaDePokemons, rand);
        Jogador jogador = new Jogador("Rafael", pokemons);
        int quantidadeBatalhas = 1;
        while (!listaNpcs.isEmpty()) {
            Adversario npc = escolherNPC(listaNpcs, entrada);
            System.out.printf("\nEstes são os pokémons de %s:\n", npc.getNome());
            npc.exibirListaPokemons();
            System.out.printf("\nAgora vamos definir o seu pokémon para a %dª batalha. Veja a sua lista: \n", quantidadeBatalhas);
            exibirTodosPokemons(jogador.getPokemons());
            System.out.print("Escolha o pokémon: ");
            int escolha = entrada.nextInt() - 1;
            jogador.setPokemonAtivo(jogador.getPokemons().get(escolha));

            // npc define pokemon ativo
            npc.setPokemonAtivo(npc.getPokemons().get(new Random().nextInt(3)));
            System.out.println("\nPara esta batalha serão utilizados:");
            System.out.println("Jogador: " + jogador.getNome() + " vai batalhar com " + jogador.getPokemonAtivo());
            System.out.println("NPC: " + npc.getNome() + " vai batalhar com " + npc.getPokemonAtivo());
            System.out.println();

            if (batalhar(jogador, npc, entrada, rand) == false) {
                System.out.println("Fim de jogo. Até a próxima.");
                break;
            }
            if (!listaNpcs.isEmpty()) {
                System.out.println("Você quer jogar mais uma batalha?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não. Quero sair");
                if (entrada.nextInt() == 2) {
                    break;
                } else {
                    jogador.recupearPontosDeVidaEquipe();
                }
            }
            quantidadeBatalhas++;
        }
        //System.out.println("\nPartidas que você venceu: " + quantidadeBatalhas);
        System.out.println("Fim de jogo. Até a próxima.");

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

        List<Pokemon> listaDePokemons = new ArrayList<>();
        listaDePokemons.add(pikachu);
        listaDePokemons.add(charmander);
        listaDePokemons.add(bulbasaur);
        listaDePokemons.add(squirtle);
        listaDePokemons.add(psyduck);
        listaDePokemons.add(jigglypuff);
        listaDePokemons.add(caterpie);
        listaDePokemons.add(pidgey);
        listaDePokemons.add(eevee);
        listaDePokemons.add(weedle);
        listaDePokemons.add(machop);
        listaDePokemons.add(voltorb);
        return listaDePokemons;
    }


    public static List<Adversario> gerarListaNPCS(List<Pokemon> listaDePokemons, Random rand) {
        List<Adversario> listaNpcs = new ArrayList<>();
        List<Pokemon> listaPokemonsNpc1 = escolherPokemonsNPC(listaDePokemons, rand);
        List<Pokemon> listaPokemonsNpc2 = escolherPokemonsNPC(listaDePokemons, rand);
        List<Pokemon> listaPokemonsNpc3 = escolherPokemonsNPC(listaDePokemons, rand);

        Adversario npc1 = new Adversario("Leomin", listaPokemonsNpc1, "Só falta passar para Java");
        Adversario npc2 = new Adversario("Renato", listaPokemonsNpc2, "Quem é o cantor?");
        npc2.setPedraEvolucao(1);
        npc2.evoluirPokemon(npc2.getPokemons().get(rand.nextInt(3)));
        Adversario npc3 = new Adversario("Inseguro", listaPokemonsNpc3, "Eu vou te derrotar?");
        npc3.setPedraEvolucao(2);
        while (npc3.getPedraEvolucao() > 0) {
            npc3.evoluirPokemon(npc3.getPokemons().get(rand.nextInt(3)));
        }
        listaNpcs.add(npc1);
        listaNpcs.add(npc2);
        listaNpcs.add(npc3);
        return listaNpcs;
    }

    public static Adversario escolherNPC(List<Adversario> listaNpcs, Scanner entrada) {
        System.out.println("\nEstes são os adversários disponíveis:");
        int i = 1;
        for (Adversario npc : listaNpcs) {
            System.out.println(i + " - " + npc);
            i++;
        }
        System.out.print("Escolha um adversário: ");
        Adversario npcEscolhido = listaNpcs.get(entrada.nextInt() - 1);
        System.out.println("\nVocê escolheu: " + npcEscolhido.getNome());
        System.out.println("Veja o que ele tem pra te dizer: " + npcEscolhido.getFraseDeEfeito());
        listaNpcs.remove(npcEscolhido);
        return npcEscolhido;
    }

    public static void exibirLogo() {
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
            System.out.println("\nO que deseja fazer:");
            System.out.println("1 - Definir um novo pokémon para a batalha:");
            System.out.println("2 - Reviver o seu pokémon");
            switch (entrada.nextInt()) {
                case 1:
                    System.out.println("Qual será o seu próximo pokémon?");
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
                    System.out.println();
                    System.out.println("Estes são os seus pokémons: ");
                    if (!reviverPokemon(jogador, entrada)) {
                        exibirOpcoes(jogador, entrada);
                        break;
                    }
            }
        }
    }

    public static void exibirTodosPokemons(List<Pokemon> pokemons) {
        int i = 1;
        for (Pokemon pokemon : pokemons) {
            if (pokemons.size() <= 3) {
                System.out.printf("%d - %-10s\n", i, pokemon.getNome());
                i++;
            } else {
                if ((i - 1) % 2 == 0 && i != 1) {
                    System.out.println();
                }
                System.out.printf("%d - %-10s", i, pokemon.getNome());
                System.out.printf("\t\t");
                i++;
            }
        }
        System.out.println();
    }

    public static List<Pokemon> escolherPokemons(List<Pokemon> listaDePokemons, Scanner entrada) {

        List<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("\nLista de pokémons disponíveis:");
            exibirTodosPokemons(listaDePokemons);
            System.out.printf("Escolha o %dº pokémon: ", i + 1);
            int escolha = entrada.nextInt();
            pokemons.add(listaDePokemons.get(escolha - 1));
            listaDePokemons.remove(escolha - 1);
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
        return pokemons;
    }

    public static void verificaPokemonJogador(Jogador jogador, Scanner entrada) {
        Pokemon pokemonAtivo = jogador.getPokemonAtivo();
        if (pokemonAtivo.getPontosDeVida() == 0) {
            System.out.printf("O seu %s foi derrotado.%n", pokemonAtivo.getNome());
            if (!jogador.getRevive() && timeFoiDerrotado(jogador)) {
                return;
            }
            exibirOpcoes(jogador, entrada);
        }
    }

    public static Boolean reviverPokemon(Treinador treinador, Scanner entrada) {
        if (!treinador.getRevive()) {
            System.out.println("Você já utilizou o seu revive.");
            return false;
        }

        treinador.exibirListaPokemons();
        System.out.print("Escolha o pokémon para reviver: ");
        Pokemon pokemonParaReviver = treinador.getPokemons().get(entrada.nextInt() - 1);
        if (pokemonParaReviver.getPontosDeVida() != 0) {
            System.out.println("Impossível reviver este pokémon. Ele já está vivo!!!");
            return false;
        }
        System.out.println("Revivendo o pokémon...");
        pokemonParaReviver.setPontosDeVida(pokemonParaReviver.getVidaInicial());
        System.out.printf("O seu %s tem agora %d pontos de vida.\n", pokemonParaReviver.getNome(), pokemonParaReviver.getPontosDeVida());
        treinador.setPokemonAtivo(pokemonParaReviver);
        treinador.setRevive(false);
        return true;
    }

    public static void verificaPokemonNpc(Treinador adversario) {
        Pokemon pokemonAtivo = adversario.getPokemonAtivo();
        if (pokemonAtivo.getPontosDeVida() == 0) {
            System.out.printf("O %s do adversário foi derrotado.%n", pokemonAtivo.getNome());
        }
        while (adversario.getPokemonAtivo().getPontosDeVida() == 0) {
            int escolha = new Random().nextInt(3);
            adversario.setPokemonAtivo(adversario.getPokemons().get(escolha));
            if (adversario.getPokemonAtivo().getPontosDeVida() != 0) {
                System.out.println("O adversário irá batalhar com " + adversario.getPokemonAtivo().getNome());
            }
        }
    }

    public static boolean timeFoiDerrotado(Treinador treinador) {
        return calcularPontosDeVidaDaEquipe(treinador) == 0;
    }

    public static Integer calcularPontosDeVidaDaEquipe(Treinador treinador) {
        int pontosDeVidaDaEquipe = 0;
        for (Pokemon pokemon : treinador.getPokemons()) {
            pontosDeVidaDaEquipe += pokemon.getPontosDeVida();
        }
        return pontosDeVidaDaEquipe;
    }


    public static void vezDoJogador(Jogador jogador, Adversario adversario, Scanner entrada) {
        if (jogador.getPokemonAtivo().getPontosDeVida() < jogador.getPokemonAtivo().getVidaInicial() &&
                jogador.getRevive()) {
            System.out.println("Sua vez. Agora você pode:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Curar o seu pokémon");
            System.out.println("3 - Evoluir um pokémon");
            System.out.print("O que você quer fazer? ");
            int escolha = entrada.nextInt();
            if (escolha == 1) {
                System.out.printf("\nEstes são os golpes do %s:\n", jogador.getPokemonAtivo().getNome());
                jogador.exibirListaGolpes(jogador.getPokemonAtivo());
                int ataque = entrada.nextInt();

                jogador.atacar(adversario, ataque);
            } else if (escolha == 2) {
                System.out.println("Curando o pokemon...");
                jogador.curarPokemon();
                System.out.printf("O %s foi curado e agora tem %d pontos de vida",
                        jogador.getPokemonAtivo().getNome(), jogador.getPokemonAtivo().getPontosDeVida());
            } else if (escolha == 3) {
                System.out.println("Qual pokémon você quer evoluir?");
                jogador.exibirListaPokemons();
                int option = entrada.nextInt() - 1;
                if (!jogador.evoluirPokemon(jogador.getPokemons().get(option))) {
                    vezDoJogador(jogador, adversario, entrada);
                }
            }

        } else {
            System.out.println("Sua vez. Agora você pode:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Evoluir um pokémon");
            System.out.print("O que você quer fazer? ");
            int escolha = entrada.nextInt();
            if (escolha == 1) {
                System.out.printf("\nEstes são os golpes do %s:\n", jogador.getPokemonAtivo().getNome());
                jogador.exibirListaGolpes(jogador.getPokemonAtivo());
                System.out.print("Como quer atacar? ");
                int ataque = entrada.nextInt();
                System.out.println();
                jogador.atacar(adversario, ataque);
            } else if (escolha == 2) {
                if (jogador.getPedraEvolucao() == 0) {
                    System.out.println("Impossível! Você não tem a pedra da evolução.\n");
                    vezDoJogador(jogador, adversario, entrada);
                } else {
                    System.out.println("Qual pokémon você quer evoluir?");
                    jogador.exibirListaPokemons();
                    int option = entrada.nextInt() - 1;
                    if (!jogador.evoluirPokemon(jogador.getPokemons().get(option))) {
                        vezDoJogador(jogador, adversario, entrada);
                    }
                }
            }
        }
    }

    public static Boolean batalhar(Jogador jogador, Adversario adversario, Scanner entrada, Random rand) {
        while (true) {

            vezDoJogador(jogador, adversario, entrada);
            if (timeFoiDerrotado(adversario)) {
                System.out.println("Acabou a batalha. Você ganhou!");
                break;
            }
            verificaPokemonNpc(adversario);
            System.out.println("Agora é a vez do seu adversário");
            int ataque = rand.nextInt(3) + 1;
            adversario.atacar(jogador, ataque);
            verificaPokemonJogador(jogador, entrada);
            if (timeFoiDerrotado(jogador)) {
                System.out.println("Acabou a batalha. Você perdeu!");
                return false;
            }
            exibirStatusRodada(jogador, adversario);
        }
        return true;
    }

    public static void exibirStatusRodada(Jogador jogador, Adversario adversario) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Verifique os pontos de vida dos pokémons após esta rodada: ");
        System.out.printf("Equipe %s: %s tem %d pontos de vida.\n",
                jogador.getNome(), jogador.getPokemonAtivo().getNome(), jogador.getPokemonAtivo().getPontosDeVida());
        System.out.printf("Equipe %s: %s tem %d pontos de vida.\n",
                adversario.getNome(), adversario.getPokemonAtivo().getNome(), adversario.getPokemonAtivo().getPontosDeVida());
        System.out.println("------------------------------------------------------------");
    }

}