import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    static Scanner scannerRead = new Scanner(System.in);

    static ArrayList<Pokemon> poolOfPokemon = new ArrayList<>();
    static ArrayList<Pokemon> teamPokemon = new ArrayList<>();
    static ArrayList<Pokemon> rivalPokemon = new ArrayList<>();

    static Move rasierblatt = new Move("Rasierblatt", "Pflanze", 55, 25, 95);


    public static void generateMoves() {
    }

    public static void generatePokemon() {

        Pokemon bisaflor = new Pokemon("Bisaflor", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon turtok = new Pokemon("Turtok", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon glurak = new Pokemon("Glurak", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);
        Pokemon mewtu = new Pokemon("Mewtu", "Pflanze", rasierblatt, 50, 80, 100, 83, 80);

        poolOfPokemon.add(bisaflor);
        poolOfPokemon.add(turtok);
        poolOfPokemon.add(glurak);
        poolOfPokemon.add(mewtu);

    }

    public static void startGame() {

        String start = "Hallo! Bitte gib dir selbst einen Namen: ";
        System.out.print(start);
        String name = scannerRead.nextLine();
        System.out.println("Hallo " + name + "!");

        generatePokemon();
        selectPokemon();
        rivalPokemon();
    }

    public static void selectPokemon() {

        String selectPokemon = "Bitte wähle nun drei Pokemon für dein Team aus.";
        System.out.println(selectPokemon);

        do {

            for (Pokemon poke:poolOfPokemon) {
                System.out.println("("+(poolOfPokemon.indexOf(poke) + 1)+") " + poke.getName());
            }

            try {
                System.out.print("Auswahl des ersten Pokemons: ");
                int pokemonNumber = scannerRead.nextInt();
                teamPokemon.add(poolOfPokemon.get((pokemonNumber - 1)));
                poolOfPokemon.remove((pokemonNumber - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Bitte wählen Sie ein Pokemon aus der Liste aus.");
            }

        } while (teamPokemon.size() < 3);

        for(Pokemon poke:teamPokemon) {
            System.out.print(poke.getName());
        }

    }

    public static void rivalPokemon() {

        while(rivalPokemon.size() < 3) {
            try {
                int pokemonNumber = (int) (Math.random() * poolOfPokemon.size() + 1);
                teamPokemon.add(poolOfPokemon.get((pokemonNumber - 1)));
                poolOfPokemon.remove((pokemonNumber - 1));
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }


    }

}
