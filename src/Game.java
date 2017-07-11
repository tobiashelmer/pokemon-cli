import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final static int TEAM_COUNT = 3;
    private static String yourInputText = "Eingabe: ";

    private static Scanner scannerRead = new Scanner(System.in);
    private static ArrayList<Pokemon> poolOfPokemon = new ArrayList<>();
    private static ArrayList<Pokemon> teamPokemon = new ArrayList<>();
    private static ArrayList<Pokemon> rivalPokemon = new ArrayList<>();

    // normal moves
    private static Move tackle = new Move("Tackle", "Normal", 50, 35, 100);
    private static Move ruckzuckhieb = new Move("Ruckzuckhieb", "Normal", 40, 30, 100);

    // grass moves
    private static Move rasierblatt = new Move("Rasierblatt", "Pflanze", 55, 25, 95);

    // fire moves
    private static Move flammenwurf = new Move("Flammenwurf", "Feuer", 90, 15, 100);

    // water moves
    private static Move surfer = new Move("Surfer", "Wasser", 90, 15, 100);

    // misc moves
    private static Move erdbeben = new Move("Erdbeben", "Boden", 100, 10, 100);
    private static Move spukball = new Move("Spukbal", "Geist", 80, 15, 100);
    private static Move donnerblitz = new Move("Donnerblitz", "Elektro", 90, 15, 100);
    private static Move psychokinese = new Move("Psychokinese", "Psycho", 90, 10, 100);
    private static Move windstoss = new Move("Windstoß", "Flug", 60, 35, 100);
    private static Move drachenwut = new Move("Drachenwut", "Drache", 40, 10, 100);
    private static Move steinhagel = new Move("Steinhagel", "Gestein", 75, 10, 90);


    /**
     * starts the game and calls functions to play the game
     */
    static void startGame() {

        generatePlayer();
        generatePokemon();
        selectPokemon();
        rivalPokemon();
        do {
            battle(teamPokemon, rivalPokemon);
        } while (!teamPokemon.isEmpty() && !rivalPokemon.isEmpty());

    }

    /**
     * create player and rival and set names for them
     */
    private static void generatePlayer() {
        String openingText = "Hallo! Herzlich willkommen in der Welt der POKéMON! Mein Name ist EICH! Man nennt mich den POKéMON-PROFESSOR! Diese Welt wird von Wesen bewohnt, die man POKéMON nennt! Für manche Leute sind POKéMON Haustiere, andere tragen Kämpfe mit ihnen aus. Ich selbst habe mein Hobby zum Beruf gemacht und studiere POKéMON.";
        String followText = "... und dies ist mein Enkel. Von jeher wollt Ihr einander übertrumpfen! Hmm, wie war noch gleich sein Name? ";
        String endText = " eine unglaubliche Reise in die Welt der POKéMON erwartet Dich !Eine Welt voller Wunder, Abenteuer und Geheimnisse! Kurz gesagt, ein Traum wird wahr!";

        System.out.println(openingText);

        // Player Name
        System.out.print("Wie lautet dein Name? ");
        String playerName;
        playerName = scannerRead.next();
        Player player = new Player(playerName);
        System.out.println("... Richtig! Dein Name ist " + player.getName() + "!");

        System.out.print(followText);

        // Rival Name
        String rivalName;
        rivalName = scannerRead.next();
        Player rival = new Player(rivalName);
        System.out.println(rival.getName() + "! Stimmt! Es lag mir auf der Zunge!");

        System.out.println(player.getName() + endText);


    }

    // just a collection of object creations
    private static void generatePokemon() {

        // creating new Pokemon
        Pokemon bisaflor = new Pokemon("Bisaflor", "Pflanze", tackle, rasierblatt, 50, 80, 100, 100, 80);
        Pokemon turtok = new Pokemon("Turtok", "Wasser", tackle, surfer, 50, 79, 85, 105, 78);
        Pokemon glurak = new Pokemon("Glurak", "Feuer", tackle, flammenwurf, 50, 78, 109, 85, 100);
        Pokemon tauboss = new Pokemon("Tauboss", "Flug", ruckzuckhieb, windstoss, 50, 83, 80, 75, 101);
        Pokemon pikachu = new Pokemon("Pikachu", "Elektro", ruckzuckhieb, donnerblitz, 50, 35, 55, 50, 90);
        Pokemon garados = new Pokemon("Garados", "Wasser", tackle, surfer, 50, 95, 125, 100, 81);
        Pokemon dragoran = new Pokemon("Dragoran", "Drache", tackle, drachenwut, 50, 91, 134, 100, 80);
        Pokemon geowaz = new Pokemon("Geowaz", "Gestein", tackle, steinhagel, 50, 80, 120, 130, 45);
        Pokemon gengar = new Pokemon("Gengar", "Geist", spukball, psychokinese, 50, 60, 130, 75, 110);
        Pokemon relaxo = new Pokemon("Relaxo", "Gestein", tackle, erdbeben, 50, 160, 110, 110, 30);

        // adding Pokemon to ArrayList
        poolOfPokemon.add(bisaflor);
        poolOfPokemon.add(turtok);
        poolOfPokemon.add(glurak);
        poolOfPokemon.add(tauboss);
        poolOfPokemon.add(pikachu);
        poolOfPokemon.add(garados);
        poolOfPokemon.add(dragoran);
        poolOfPokemon.add(geowaz);
        poolOfPokemon.add(gengar);
        poolOfPokemon.add(relaxo);
    }

    // select three pokemon for the fight and displays them at the end
    private static void selectPokemon() {

        String selectPokemonText = "\nBitte wähle nun drei Pokemon für dein Team aus.";
        System.out.println(selectPokemonText);

        // needs 3 pokemon to complete the loop
        do {

            // prints out pokemon available from the whole pool
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

            // catches if you enter a number not available
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

        String yourPokemonTeamText = "\nGewählte Pokemon: ";
        System.out.print(yourPokemonTeamText);

        // prints out selected pokemon from teamArray
        for (Pokemon pokemon : teamPokemon) {
            String yourPokemonTeamSeperatorText;
            String yourPokemonTeamSeperatorChar = ",";
            String yourPokemonTeamSeperatorWord = "und";

            if (teamPokemon.indexOf(pokemon) == (TEAM_COUNT - 2)) {
                yourPokemonTeamSeperatorText = " " + yourPokemonTeamSeperatorWord + " ";
            } else if (teamPokemon.indexOf(pokemon) != (TEAM_COUNT - 1)) {
                yourPokemonTeamSeperatorText = yourPokemonTeamSeperatorChar + " ";
            } else {
                yourPokemonTeamSeperatorText = "";
            }
            System.out.print(pokemon.getName() + yourPokemonTeamSeperatorText);
        }
    }

    // selects three random pokemon remaining from poolOfPokemon for the rival
    private static void rivalPokemon() {

        while (rivalPokemon.size() < TEAM_COUNT) {

            // catches if you enter a number not available
            try {
                int pokemonNumber = (int) (Math.random() * poolOfPokemon.size());
                rivalPokemon.add(poolOfPokemon.get(pokemonNumber));
                poolOfPokemon.remove(pokemonNumber);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * select pokemon for the fight
     *
     * @return enterNumber as int
     */
    private static int choosePokemon() {

        int enterNumber;
        String chooseYourPokemonText = "\n\nWähle dein Pokemon zum Kämpfen aus.";
        System.out.println(chooseYourPokemonText);

        for (Pokemon pokemon : teamPokemon) {
            System.out.println("(" + (teamPokemon.indexOf(pokemon) + 1) + ") " + pokemon.getName());
        }

        System.out.print(yourInputText);
        enterNumber = scannerRead.nextInt();

        // -1 is necessary because Array starts at 0 and not at 1
        return enterNumber - 1;
    }

    /**
     * pokemon battle as in the games
     * pokemon which is faster attacks first, enemy selects random move to attack with
     * if defeated, pokemon gets removed from ArrayList and next will be selected
     * if no pokemon is available you lost
     *
     * @param teamPokemon  as ArrayList<Pokemon>
     * @param rivalPokemon as ArrayList<Pokemon>
     */
    private static void battle(ArrayList<Pokemon> teamPokemon, ArrayList<Pokemon> rivalPokemon) {

        int activePokemon = choosePokemon();
        int selectMove;
        String paragraphText = "\n";

        Pokemon yourPokemon = teamPokemon.get(activePokemon);
        Pokemon rivalPkmn = rivalPokemon.get(0);


        // once a pokemon is fainted everything starts again
        do {
            // generates random number (0, 1) to select attack for rival
            int randomMove = (int) (Math.random() * 1);
            System.out.println(paragraphText);
            renderHealthBar(rivalPkmn);
            System.out.print(paragraphText);
            renderHealthBar(yourPokemon);

            // prints out pokemon's moves
            System.out.print("Attacken: ");
            ArrayList<Move> movePool = yourPokemon.getMoves();
            for (Move move : movePool) {
                System.out.print("(" + (movePool.indexOf(move) + 1) + ") " + move.getName() + " ");
            }

            System.out.print(paragraphText + yourInputText);

            selectMove = scannerRead.nextInt();
            System.out.println(paragraphText);

            // if own pokemon is faster, attack first otherwise rival attacks first
            if (yourPokemon.getSpeed() > rivalPkmn.getSpeed()) {
                Move.calculateDamage(movePool.get(selectMove - 1), yourPokemon, rivalPokemon.get(0), false);
                if (rivalPkmn.getHealthPoints() > 0) {
                    Move.calculateDamage(movePool.get(randomMove), rivalPokemon.get(0), yourPokemon, true);
                }
            } else {
                Move.calculateDamage(movePool.get(randomMove), rivalPokemon.get(0), yourPokemon, true);
                if (yourPokemon.getHealthPoints() > 0) {
                    Move.calculateDamage(movePool.get(selectMove - 1), yourPokemon, rivalPokemon.get(0), false);
                }
            }

        } while (yourPokemon.isAlive() && rivalPkmn.isAlive());

        // checks if own pokemon fainted and removes it from the ArrayList
        if (!yourPokemon.isAlive()) {
            System.out.println(yourPokemon.getName() + " wurde besiegt");
            removePokemonFromList(teamPokemon, activePokemon);
        }

        // checks if rival pokemon fainted and removes it from the ArrayList
        if (!rivalPkmn.isAlive()) {
            System.out.println(rivalPkmn.getName() + " (Gegner) wurde besiegt!");
            removePokemonFromList(rivalPokemon, 0);
        }

        // if no pokemon is available you/the rival lost
        if (teamPokemon.isEmpty()) {
            System.out.println("Du wurdest besiegt!");
        } else if (rivalPokemon.isEmpty()) {
            System.out.println("Du besiegst " + rival.getName() + "!");
        }

    }

    /**
     * displays heathbar, name and level of the pokemon
     *
     * @param pokemon as Pokemon
     */
    private static void renderHealthBar(Pokemon pokemon) {

        String pokemonName = pokemon.getName();
        int pokemonLevel = pokemon.getLevel();
        int currentHP = pokemon.getHealthPoints();
        int maximumHP = pokemon.getMaxHealthPoints();

        System.out.println(pokemonName + " | Level: " + pokemonLevel);
        System.out.println(currentHP + " | " + maximumHP + " KP");
    }

    /**
     * removes pokemon from ArrayList
     *
     * @param listOfPokemon       as ArrayList<Pokemon>
     * @param positionInArrayList as int
     */
    private static void removePokemonFromList(ArrayList<Pokemon> listOfPokemon, int positionInArrayList) {

        listOfPokemon.remove(positionInArrayList);

    }

}