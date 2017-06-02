import java.util.Random;

public class Move {
	
	final static double STAB_MULTIPLIER = 1.5; 
	final static double CRIT_MULTIPLIER = 2; 
	
	private String moveName;
	private String moveType;
	private int movePower;
	private int movePowerPoints;
	private int moveAccuracy;
	
	/**
	 * Class Constructor
	 * @param name as String
	 * @param type as String
	 * @param power as int
	 * @param powerpoints as int
	 * @param accuracy as int
	 */
	public Move(String name, String type, int power, int powerpoints, int accuracy) {
		this.moveName = name;
		this.moveType = type;
		this.movePower = power;
		this.movePowerPoints = powerpoints;
		this.moveAccuracy = accuracy;
	}
	
	/**
	 * Get the name of move 
	 * @return String
	 */
	public String getmoveName() {
		return moveName;
	}
	
	/**
	 * Set the name of move
	 * @param move as String 
	 */
	public void setmoveName(String move) {
		this.moveName = move;
	}
	
	/**
	 * Get the type of move 
	 * @return String
	 */
	public String getmoveType() {
		return moveType;
	}
	
	/**
	 * Set the type of move 
	 * @param type as String
	 */
	public void setmoveType(String type) {
		this.moveType = type;
	}
	
	/**
	 * Get the power of move 
	 * @return int
	 */
	public int getmovePower() {
		return movePower;
	}
	
	/**
	 * Set the power of move
	 * @param power as int 
	 */
	public void setmovePower(int power) {
		this.movePower = power;
	}
	
	/**
	 * Get the power points of move 
	 * @return int
	 */
	public int getmovePowerPoints() {
		return movePowerPoints;
	}
	
	/**
	 * Set the power points of move
	 * @param powerpoints as int 
	 */
	public void setmovePowerPoints(int powerpoints) {
		this.movePowerPoints = powerpoints;
	}
	
	/**
	 * Get the accuracy of move 
	 * @return int
	 */
	public int getmoveAccuracy() {
		return moveAccuracy;
	}
	
	/**
	 * Set the accuracy of move
	 * @param accuracy as int 
	 */
	public void setmoveAccuracy(int accuracy) {
		this.moveAccuracy = accuracy;
	}
	
	/**
	 * Calculates the damage done by the moveer pokemon and returns it as int
	 * @param move as move
	 * @param moveer as Pokemon
	 * @param defender as Pokemon
	 * @return int
	 */
	public static int calculateDamage(Move move, Pokemon attacker, Pokemon defender) {
		
		boolean stab = isStab(move, attacker);
		boolean crit = isCriticalHit();
		double multiplier = 1;
		int damage;
		int hp = defender.getHealthPoints();
		int movePower = move.getmovePower();
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
		
		// damage calculation
		damage = (int) ((((((2*5)/5)+2) * movePower * (attackerAttack / defenderDefense) / 50) + 2) * multiplier);

		// lowers Pokemon HP by the damage dealt
		defender.setHealthPoints(hp - damage);
		
		// prints out damage message
		System.out.println(move.getmoveName() + " hat " + damage + " Schaden zugefuegt!");
		 
		return damage;
	}
	
	
	/**
	 * Same Type move Bonus (STAB)
	 * <br>
	 * 50% damage boost of an move when it is the same type as one of the types of the Pokemon using the move
	 * 
	 * @param move as move
	 * @param pokemon as Pokemon
	 * @return boolean
	 */
	public static boolean isStab(Move move, Pokemon pokemon) {
		
		boolean stab = false;
		String moveType = move.getmoveType();
		String pokemonType = pokemon.getType();
		
		// if move type matches pokemon type set stab to true
		if (moveType.equals(pokemonType)) {
			stab = true;
		}
		
		return stab;
		
	}
	
	/**
	 * Random event that doubles the damage of a damage-dealing move. 
	 * @return boolean
	 */
	public static boolean isCriticalHit() {
				
		boolean criticalHit = false;
		Random random = new Random();
	    double chance = random.nextInt(100);
	    
	    // simulates a 6.25% chance of a critical hit
	    if (chance < 6.25) {
	    	criticalHit = true;
	    	System.out.println("Ein Volltreffer!");
	    }

	    return criticalHit;
	}
	
	
}