import java.util.Random;

public class Attack {
	
	public static final double STAB_MULTIPLIER = 1.5; 
	public static final double CRIT_MULTIPLIER = 2; 
	
	private String attackName;
	private String attackType;
	private int attackPower;
	private int attackPowerPoints;
	private int attackAccuracy;
	
	/**
	 * Constructor
	 */
	public Attack(String name, String type, int power, int pp, int acc) {
		this.attackName = name;
		this.attackType = type;
		this.attackPower = power;
		this.attackPowerPoints = pp;
		this.attackAccuracy = acc;
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
	 */
	public void setAttackPowerPoints(int pp) {
		this.attackPowerPoints = pp;
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
	 */
	public void setAttackAccuracy(int acc) {
		this.attackAccuracy = acc;
	}
	
	
	public static int calculateDamage(Attack attack, Pokemon attacker, Pokemon defender) {
		
		boolean stab = isStab(attack, attacker);
		boolean crit = isCriticalHit();
		double multiplier = 1;
		
		int damage;
		int hp = defender.getHealthPoints();
		int attackPower = attack.getAttackPower();
		int attackerAttack = attacker.getAttack();
		int defenderDefense = defender.getDefense();
		
		
		if (stab) {
			multiplier *= STAB_MULTIPLIER;
		}
		
		if (crit) {
			multiplier *= CRIT_MULTIPLIER;
		}
		
		damage = (int) ((((((2*5)/5)+2) * attackPower * (attackerAttack / defenderDefense) / 50) + 2) * multiplier);

		defender.setHealthPoints(hp - damage);
		
		System.out.println(attack.getAttackName() + " hat " + damage + " Schaden zugefuegt!");
		 
		return damage;
	}
	
	
	/**
	 * Same Type Attack Bonus (STAB)
	 * 50% damage boost of an attack when it is the same type as one of the types of the Pokemon using the attack
	 */
	public static boolean isStab(Attack attack, Pokemon pokemon) {
		
		boolean stab = false;
		String attackType = attack.getAttackType();
		String pokemonType = pokemon.getType();
		
		if (attackType.equals(pokemonType)) {
			stab = true;
		}
		
		return stab;
		
	}
	
	/**
	 * Critical Hit
	 * Random event that doubles the damage of a damage-dealing move. 
	 */
	public static boolean isCriticalHit() {
				
		boolean criticalHit = false;
		Random random = new Random();
	    double chance = random.nextInt(100);
	    
	    if (chance < 6.25) { // 6.25%
	    	criticalHit = true;
	    	System.out.println("Ein Volltreffer!");
	    }

	    return criticalHit;
	}
	
	
}