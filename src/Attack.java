import java.util.Random;

public class Attack {
	
	final static double STAB_MULTIPLIER = 1.5; 
	final static double CRIT_MULTIPLIER = 2; 
	
	private String attackName;
	private String attackType;
	private int attackPower;
	private int attackPowerPoints;
	private int attackAccuracy;
	
	/**
	 * Class Constructor
	 * @param name as String
	 * @param type as String
	 * @param power as int
	 * @param powerpoints as int
	 * @param accuracy as int
	 */
	public Attack(String name, String type, int power, int powerpoints, int accuracy) {
		this.attackName = name;
		this.attackType = type;
		this.attackPower = power;
		this.attackPowerPoints = powerpoints;
		this.attackAccuracy = accuracy;
	}
	
	/**
	 * Get the name of attack 
	 * @return String
	 */
	public String getAttackName() {
		return attackName;
	}
	
	/**
	 * Set the name of attack
	 * @param attack as String 
	 */
	public void setAttackName(String attack) {
		this.attackName = attack;
	}
	
	/**
	 * Get the type of attack 
	 * @return String
	 */
	public String getAttackType() {
		return attackType;
	}
	
	/**
	 * Set the type of attack 
	 * @param type as String
	 */
	public void setAttackType(String type) {
		this.attackType = type;
	}
	
	/**
	 * Get the power of attack 
	 * @return int
	 */
	public int getAttackPower() {
		return attackPower;
	}
	
	/**
	 * Set the power of attack
	 * @param power as int 
	 */
	public void setAttackPower(int power) {
		this.attackPower = power;
	}
	
	/**
	 * Get the power points of attack 
	 * @return int
	 */
	public int getAttackPowerPoints() {
		return attackPowerPoints;
	}
	
	/**
	 * Set the power points of attack
	 * @param powerpoints as int 
	 */
	public void setAttackPowerPoints(int powerpoints) {
		this.attackPowerPoints = powerpoints;
	}
	
	/**
	 * Get the accuracy of attack 
	 * @return int
	 */
	public int getAttackAccuracy() {
		return attackAccuracy;
	}
	
	/**
	 * Set the accuracy of attack
	 * @param accuracy as int 
	 */
	public void setAttackAccuracy(int accuracy) {
		this.attackAccuracy = accuracy;
	}
	
	/**
	 * Calculates the damage done by the attacker pokemon and returns it as int
	 * @param attack as Attack
	 * @param attacker as Pokemon
	 * @param defender as Pokemon
	 * @return int
	 */
	public static int calculateDamage(Attack attack, Pokemon attacker, Pokemon defender) {
		
		boolean stab = isStab(attack, attacker);
		boolean crit = isCriticalHit();
		double multiplier = 1;
		int damage;
		int hp = defender.getHealthPoints();
		int attackPower = attack.getAttackPower();
		int attackerAttack = attacker.getAttack();
		int defenderDefense = defender.getDefense();
		
		// if type matches (see isStab()) adds STAB_MULTIPLIER to multiplier
		if (stab) {
			multiplier *= STAB_MULTIPLIER;
		}
		
		// if attack crits (see isCrit()) adds CRIT_MULTIPLIER to multiplier
		if (crit) {
			multiplier *= CRIT_MULTIPLIER;
		}
		
		// damage calculation
		damage = (int) ((((((2*5)/5)+2) * attackPower * (attackerAttack / defenderDefense) / 50) + 2) * multiplier);

		// lowers Pokemon HP by the damage dealt
		defender.setHealthPoints(hp - damage);
		
		// prints out damage message
		System.out.println(attack.getAttackName() + " hat " + damage + " Schaden zugefuegt!");
		 
		return damage;
	}
	
	
	/**
	 * Same Type Attack Bonus (STAB)
	 * <br>
	 * 50% damage boost of an attack when it is the same type as one of the types of the Pokemon using the attack
	 * 
	 * @param attack as Attack
	 * @param pokemon as Pokemon
	 * @return boolean
	 */
	public static boolean isStab(Attack attack, Pokemon pokemon) {
		
		boolean stab = false;
		String attackType = attack.getAttackType();
		String pokemonType = pokemon.getType();
		
		// if attack type matches pokemon type set stab to true
		if (attackType.equals(pokemonType)) {
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