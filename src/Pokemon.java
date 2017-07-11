import java.util.ArrayList;

public class Pokemon {

    private ArrayList<Move> poolOfMoves = new ArrayList<>();

    private String name;
    private String type;

    Move moveOne;
    Move moveTwo;

    private int baseHealthPoints;
    private int baseAttack;
    private int baseDefense;
    private int baseSpeed;

    private int healthPointsIv;
    private int attackIv;
    private int defenseIv;
    private int speedIv;

    private int level;
    private int maxHealthPoints;
    private int currentHealthPoints;
    private int attack;
    private int defense;
    private int speed;


    /**
     * Class Constructor
     *
     * @param name             as String
     * @param type             as String
     * @param moveOne          as Attack
     * @param level            as int
     * @param baseHealthpoints as int
     * @param baseAttack       as int
     * @param baseDefense      as int
     * @param baseSpeed        as int
     */
    public Pokemon(String name, String type, Move moveOne, Move moveTwo, int level, int baseHealthpoints, int baseAttack, int baseDefense, int baseSpeed) {
        this.name = name;
        this.type = type;
        this.moveOne = moveOne;
        this.moveTwo = moveTwo;
        this.level = level;
        this.baseHealthPoints = baseHealthpoints;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseSpeed = baseSpeed;
        this.poolOfMoves.add(this.moveOne);
        this.poolOfMoves.add(this.moveTwo);

        calculateStats(level, baseHealthpoints, baseAttack, baseDefense, baseSpeed);
    }

    /**
     * Get Pokemon Name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set Pokemon name
     *
     * @param name as String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Pokemon type
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Set Pokemon type
     *
     * @param type as String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get Pokemon Level
     *
     * @return level as int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set Pokemon level
     *
     * @param level as int
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get Pokemon current health points
     *
     * @return int
     */
    public int getHealthPoints() {
        return currentHealthPoints;
    }

    /**
     * Set Pokemon health points
     *
     * @param hp as int
     */
    public void setHealthPoints(int hp) {
        this.currentHealthPoints = hp;
    }

    /**
     * Get Pokemon maximum health points
     *
     * @return int
     */
    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    /**
     * Set Pokemon maximum health points
     *
     * @param maxHp as int
     */
    public void setMaxHealthPoints(int maxHp) {
        this.maxHealthPoints = maxHp;
    }

    /**
     * Get Pokemon health points iv
     *
     * @return int
     */
    public int getHealthPointsIV() {
        return healthPointsIv;
    }

    /**
     * Set Pokemon  health points iv
     *
     * @param hpIv as int
     */
    public void setHealthPointsIV(int hpIv) {
        this.healthPointsIv = hpIv;
    }

    /**
     * Get Pokemon defense
     *
     * @return int
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Set Pokemon defense
     *
     * @param defense as int
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Get Pokemon defense iv
     *
     * @return int
     */
    public int getDefenseIV() {
        return defenseIv;
    }

    /**
     * Set Pokemon defense iv
     *
     * @param defenseIv as int
     */
    public void setDefenseIV(int defenseIv) {
        this.defenseIv = defenseIv;
    }

    /**
     * Get Pokemon attack
     *
     * @return int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Set Pokemon attack
     *
     * @param attack as int
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Get Pokemon attack iv
     *
     * @return int
     */
    public int getAttackIV() {
        return attackIv;
    }

    /**
     * Set Pokemon attack
     *
     * @param attackIv as int
     */
    public void setAttackIV(int attackIv) {
        this.attackIv = attackIv;
    }

    /**
     * Get Pokemon speed
     *
     * @return int
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set Pokemon soeed
     *
     * @param speed as int
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Get Pokemon speed iv
     *
     * @return int
     */
    public int getSpeedIV() {
        return speedIv;
    }

    /**
     * Set Pokemon soeed iv
     *
     * @param speedIv as int
     */
    public void setSpeedIV(int speedIv) {
        this.speedIv = speedIv;
    }

    /**
     * Get Moves
     *
     * @return Moves as Array
     */
    public ArrayList<Move> getMoves() {
        return poolOfMoves;
    }

    /**
     * generates and returns a random number between 1 and 31
     *
     * @return int
     */
    private int generateIntermidateValue() {

        return (int) (Math.random() * 31 + 1);
    }


    /**
     * calculates stats based on base values and random generated iv
     *
     * @param level            as int
     * @param baseHealthPoints as int
     * @param baseAttack       as int
     * @param baseDefense      as int
     * @param baseSpeed        as int
     */
    private void calculateStats(int level, int baseHealthPoints, int baseAttack, int baseDefense, int baseSpeed) {

        // Stats = ((2 * basevalue + iv + ev/4) * lvl / 100 + 5) * nature
        // HP = (2 * basevalue + iv + ev/4 + 100) * lvl / 100 + 10

        // generate and set health points iv
        int hpIv = generateIntermidateValue();
        this.setHealthPointsIV(hpIv);
        // calculate and set health points + max health points
        int healthPoints = (2 * baseHealthPoints + hpIv + 100) * level / 100 + 10;
        this.setHealthPoints(healthPoints);
        this.setMaxHealthPoints(healthPoints);

        // generate and set attack iv
        int attackIv = generateIntermidateValue();
        this.setAttackIV(attackIv);
        // calculate and set attack
        int attack = (2 * baseAttack + attackIv) * level / 100 + 5;
        this.setAttack(attack);

        // generate and set defense iv
        int defenseIv = generateIntermidateValue();
        this.setDefenseIV(defenseIv);
        // calculate and set defense
        int defense = (2 * baseDefense + defenseIv) * level / 100 + 5;
        this.setDefense(defense);

        // generate and set speed iv
        int speedIv = generateIntermidateValue();
        this.setSpeedIV(speedIv);
        // calculate and set speed
        int speed = (2 * baseSpeed + speedIv) * level / 100 + 5;
        this.setSpeed(speed);
    }

    public boolean isAlive() {
        return (currentHealthPoints >= 0);
    }
}
