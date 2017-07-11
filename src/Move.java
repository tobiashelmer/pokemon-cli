import java.util.Random;

public class Move {

    private final static double STAB_MULTIPLIER = 1.5;
    private final static double CRIT_MULTIPLIER = 2;
    private final static double TYPE_MULTIPLIER_EFFECTIVE = 2;
    private final static double TYPE_MULTIPLIER_INEFFECTIVE = 0.5;

    private String name;
    private String type;
    private int power;
    private int powerPoints;
    private int maxPowerPoints;
    private int accuracy;

    /**
     * Class Constructor
     *
     * @param name        as String
     * @param type        as String
     * @param power       as int
     * @param powerpoints as int
     * @param accuracy    as int
     */
    public Move(String name, String type, int power, int powerpoints, int accuracy) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.powerPoints = powerpoints;
        this.maxPowerPoints = powerpoints;
        this.accuracy = accuracy;
    }

    /**
     * Get the name of move
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of move
     *
     * @param move as String
     */
    public void setName(String move) {
        this.name = move;
    }

    /**
     * Get the type of move
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of move
     *
     * @param type as String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the power of move
     *
     * @return int
     */
    public int getPower() {
        return power;
    }

    /**
     * Set the power of move
     *
     * @param power as int
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Get the power points of move
     *
     * @return int
     */
    public int getPowerPoints() {
        return powerPoints;
    }

    /**
     * Set the power points of move
     *
     * @param powerpoints as int
     */
    public void setPowerPoints(int powerpoints) {
        this.powerPoints = powerpoints;
    }

    /**
     * Get the accuracy of move
     *
     * @return int
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * Set the accuracy of move
     *
     * @param accuracy as int
     */
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * Calculates the damage done by the attacker pokemon and returns it as int
     *
     * @param move     as move
     * @param attacker as Pokemon
     * @param defender as Pokemon
     * @return int
     */
    public static int calculateDamage(Move move, Pokemon attacker, Pokemon defender, boolean rival) {

        String effectiveText;
        String critText = "Ein Volltreffer! ";

        boolean stab = isStab(move, attacker);
        boolean crit = isCriticalHit();
        double effective = isEffective(move, defender);
        double multiplier = 1;
        double modifier;
        int damage;
        int level = attacker.getLevel();
        int hp = defender.getHealthPoints();
        int movePower = move.getPower();
        int attackerAttack = attacker.getAttack();
        int defenderDefense = defender.getDefense();

        // if type matches (see isStab()) adds STAB_MULTIPLIER to multiplier
        if (stab) {
            multiplier *= STAB_MULTIPLIER;
        }

        // if move crits (see isCrit()) adds CRIT_MULTIPLIER to multiplier
        if (crit) {
            multiplier *= CRIT_MULTIPLIER;
        }

        if (effective == 2) {
            effectiveText = "Das ist sehr effektiv!";
        } else if (effective == 0.5) {
            effectiveText = "Das ist nicht sehr effektiv..";
        } else {
            effectiveText = "";
        }

        modifier = multiplier * effective;

        // damage calculation
        damage = (int) (((((((2 * level) / 5) + 2) * movePower * attackerAttack / defenderDefense) / 50) + 2) * modifier);

        // lowers Pokemon HP by the damage dealt
        defender.setHealthPoints(hp - damage);

        // prints out damage message
        if (rival) {
            System.out.println((crit ? critText : "") + attacker.getName() + " (Gegner) setzt " + move.getName() + " ein und hat dir " + damage + " Schaden zugefügt! " + effectiveText);
        } else {
            System.out.println((crit ? critText : "") + attacker.getName() + " setzt " + move.getName() + " ein und hat " + defender.getName() + " (Gegner) " + damage + " Schaden zugefügt! " + effectiveText);
        }

        return damage;
    }


    /**
     * Same Type move Bonus (STAB)
     * 50% damage boost of an move when it is the same type as one of the types of the Pokemon using the move
     *
     * @param move    as move
     * @param pokemon as Pokemon
     * @return boolean
     */
    private static boolean isStab(Move move, Pokemon pokemon) {

        boolean stab = false;
        String moveType = move.getType();
        String pokemonType = pokemon.getType();

        // if move type matches pokemon type set stab to true
        if (moveType.equals(pokemonType)) {
            stab = true;
        }

        return stab;
    }


    /**
     * Checks if attack is effective
     * 2* Damage if Attack is effective, 1/2 damage if not effective
     *
     * @param move    as move
     * @param pokemon as Pokemon
     * @return double
     */
    private static double isEffective(Move move, Pokemon pokemon) {

        double multiplier = 1;
        String moveType = move.getType();
        String pokemonType = pokemon.getType();

        // set multiplier for type Feuer
        if (moveType.equals("Feuer")) {
            if (pokemonType.equals("Pflanze") || pokemonType.equals("Eis") || pokemonType.equals("Käfer")) {
                multiplier = TYPE_MULTIPLIER_EFFECTIVE;
            } else if (pokemonType.equals("Wasser") || pokemonType.equals("Feuer") || pokemonType.equals("Gestein") || pokemonType.equals("Drache")) {
                multiplier = TYPE_MULTIPLIER_INEFFECTIVE;
            }
        }

        // set multiplier for type Normal
        if (moveType.equals("Normal")) {
            if (pokemonType.equals("Gestein") || pokemonType.equals("Stahl")) {
                multiplier = TYPE_MULTIPLIER_INEFFECTIVE;
            } else if (pokemonType.equals("Geist")) {
                multiplier = 0;
            }
        }

        // set multiplier for type Wasser
        if (moveType.equals("Wasser")) {
            if (pokemonType.equals("Feuer") || pokemonType.equals("Boden") || pokemonType.equals("Gestein")) {
                multiplier = TYPE_MULTIPLIER_EFFECTIVE;
            } else if (pokemonType.equals("Wasser") || pokemonType.equals("Pflanze") || pokemonType.equals("Drache")) {
                multiplier = TYPE_MULTIPLIER_INEFFECTIVE;
            }
        }

        // set multiplier for type Pflanze
        if (moveType.equals("Pflanze")) {
            if (pokemonType.equals("Wasser") || pokemonType.equals("Boden") || pokemonType.equals("Gestein")) {
                multiplier = TYPE_MULTIPLIER_EFFECTIVE;
            } else if (pokemonType.equals("Feuer") || pokemonType.equals("Pflanze") || pokemonType.equals("Flug") || pokemonType.equals("Drache") || pokemonType.equals("Käfer") || pokemonType.equals("Stahl")) {
                multiplier = TYPE_MULTIPLIER_INEFFECTIVE;
            }
        }

        // set multiplier for type Pflanze
        if (moveType.equals("Elektro")) {
            if (pokemonType.equals("Wasser") || pokemonType.equals("Flug")) {
                multiplier = TYPE_MULTIPLIER_EFFECTIVE;
            } else if (pokemonType.equals("Pflanze") || pokemonType.equals("Elektro") || pokemonType.equals("Drache")) {
                multiplier = TYPE_MULTIPLIER_INEFFECTIVE;
            } else if (pokemonType.equals("Boden")) {
                multiplier = 0;
            }
        }

        // set multiplier for type Eis
        if (moveType.equals("Eis")) {
            if (pokemonType.equals("Pflanze") || pokemonType.equals("Flug") || pokemonType.equals("Boden") || pokemonType.equals("Drache")) {
                multiplier = TYPE_MULTIPLIER_EFFECTIVE;
            } else if (pokemonType.equals("Feuer") || pokemonType.equals("Wasser") || pokemonType.equals("Eis") || pokemonType.equals("Stahl")) {
                multiplier = TYPE_MULTIPLIER_INEFFECTIVE;
            }
        }

        return multiplier;
    }

    /**
     * Random event that doubles the damage of a damage-dealing move.
     *
     * @return boolean
     */
    private static boolean isCriticalHit() {

        boolean criticalHit = false;
        Random random = new Random();
        double chance = random.nextInt(100);

        // simulates a 6.25% chance of a critical hit
        if (chance < 6.25) {
            criticalHit = true;
        }

        return criticalHit;
    }


}