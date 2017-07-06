import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final static int TEAM_COUNT = 3;

    private static Scanner scannerRead = new Scanner(System.in);

    private static ArrayList<Pokemon> poolOfPokemon = new ArrayList<>();
    private static ArrayList<Pokemon> teamPokemon = new ArrayList<>();
    private static ArrayList<Pokemon> rivalPokemon = new ArrayList<>();

    private static Move rasierblatt = new Move("Rasierblatt", "Pflanze", 55, 25, 95);


    public static void generateMoves() {
    }

    private static void generatePokemon() {

        Pokemon bisaflor = new Pokemon("Bisaflor", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon turtok = new Pokemon("Turtok", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon glurak = new Pokemon("Glurak", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon mewtu = new Pokemon("Mewtu", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon bisaflor2 = new Pokemon("Bisaflor2", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon turtok2 = new Pokemon("Turtok2", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon glurak2 = new Pokemon("Glurak2", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon mewtu2 = new Pokemon("Mewtu2", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);

        poolOfPokemon.add(bisaflor);
        poolOfPokemon.add(turtok);
        poolOfPokemon.add(glurak);
        poolOfPokemon.add(mewtu);
        poolOfPokemon.add(bisaflor2);
        poolOfPokemon.add(turtok2);
        poolOfPokemon.add(glurak2);
        poolOfPokemon.add(mewtu2);

    }

    static void startGame() {

        String start = "Hallo! Bitte gib dir selbst einen Namen: ";
        System.out.print(start);
        String name = scannerRead.nextLine();
        System.out.println("Hallo " + name + "!");

        generatePokemon();
        selectPokemon();
        rivalPokemon();
    }

    private static void selectPokemon() {

        String selectPokemonText = "\nBitte wähle nun drei Pokemon für dein Team aus.";
        System.out.println(selectPokemonText);

        do {

            for (Pokemon pokemon : poolOfPokemon) {
                System.out.println("(" + (poolOfPokemon.indexOf(pokemon) + 1) + ") " + pokemon.getName());
            }

            String pickPokemonNumberText;
            if (teamPokemon.size() == 0) {
                pickPokemonNumberText = "ersten";
            } else if (teamPokemon.size() == 1) {
                pickPokemonNumberText = "zweiten";
            } else {
                pickPokemonNumberText = "dritten";
            }

            try {
                String pickPokemonText = "\nAuswahl des " + pickPokemonNumberText + " Pokemons: ";
                System.out.print(pickPokemonText);
                int pokemonNumber = scannerRead.nextInt();
                teamPokemon.add(poolOfPokemon.get((pokemonNumber - 1)));
                poolOfPokemon.remove((pokemonNumber - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Bitte wählen Sie ein Pokemon aus der Liste aus.\n\n");
            }

        } while (teamPokemon.size() < TEAM_COUNT);

        String yourPokemonTeamText = "Gewählte Pokemon: ";
        System.out.print(yourPokemonTeamText);

        for (Pokemon pokemon : teamPokemon) {
            String yourPokemonTeamSeperatorText;
            String yourPokemonTeamSeperatorChar = ",";
            String yourPokemonTeamSeperatorWord = "und";

            if (teamPokemon.indexOf(pokemon) == (TEAM_COUNT - 2)) {
                yourPokemonTeamSeperatorText = " " + yourPokemonTeamSeperatorWord + " ";
            } else if (teamPokemon.indexOf(pokemon) != (TEAM_COUNT - 1)) {
                yourPokemonTeamSeperatorText = " " + yourPokemonTeamSeperatorChar + " ";
            } else {
                yourPokemonTeamSeperatorText = "";
            }
            System.out.print(pokemon.getName() + yourPokemonTeamSeperatorText);
        }
    }

    private static void rivalPokemon() {

        while (rivalPokemon.size() < TEAM_COUNT) {

            try {
                int pokemonNumber = (int) (Math.random() * poolOfPokemon.size());
                rivalPokemon.add(poolOfPokemon.get(pokemonNumber));
                poolOfPokemon.remove(pokemonNumber);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

}