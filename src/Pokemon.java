
public class Pokemon {
	
	private String pokemonName;
	private String pokemonType;
	
	Attack pokemonAttackOne;
	
	private int pokemonMaxHealthPoints;
	private int pokemonHealthPoints;
	private int pokemonDefense;
	private int pokemonSpeed;
	private int pokemonAttack;
	
	
	/**
	 * Class Constructor
	 * @param name as String
	 * @param type as String
	 * @param attackOne as Attack
	 * @param healthpoints as int
	 * @param attack as int
	 * @param defense as int
	 * @param speed as int
	 */
	public Pokemon(String name, String type, Attack attackOne, int healthpoints, int attack, int defense, int speed) {
		this.pokemonName = name;
		this.pokemonType = type;
		this.pokemonAttackOne = attackOne;
		this.pokemonMaxHealthPoints = healthpoints;
		this.pokemonHealthPoints = healthpoints;
		this.pokemonAttack = attack;
		this.pokemonDefense = defense;
		this.pokemonSpeed = speed;
	}
	
	/**
	 * Get Pokemon Name
	 * @return String
	 */
	public String getName() {
		return pokemonName;
	}
	
	/**
	 * Set Pokemon name
	 */
	public void setName(String name) {
		this.pokemonName = name;
	}
	
	/**
	 * Get Pokemon type
	 * @return String
	 */
	public String getType() {
		return pokemonType;
	}
	
	/**
	 * Set Pokemon type
	 */
	public void setType(String type) {
		this.pokemonType =  type;
	}
	
	/**
	 * Get Pokemon current health points
	 * @return int
	 */
	public int getHealthPoints() {
		return pokemonHealthPoints;
	}
	
	/**
	 * Set Pokemon health points
	 */
	public void setHealthPoints(int hp) {
		this.pokemonHealthPoints = hp;
	}
	
	/**
	 * Get Pokemon maximum health points
	 * @return String
	 */
	public int getMaxHealthPoints() {
		return pokemonMaxHealthPoints;
	}
	
	/**
	 * Get Pokemon defense
	 * @return int
	 */
	public int getDefense() {
		return pokemonDefense;
	}
	
	/**
	 * Set Pokemon defense
	 */
	public void setDefense(int defense) {
		this.pokemonDefense = defense;
	}

	/**
	 * Get Pokemon speed
	 * @return int
	 */
	public int getSpeed() {
		return pokemonSpeed;
	}
	
	/**
	 * Set Pokemon soeed
	 */
	public void setSpeed(int speed) {
		this.pokemonSpeed = speed;
	}
	
	/**
	 * Set Pokemon attack
	 */
	public void setAttack(int attack) {
		this.pokemonDefense = attack;
	}
	
	/**
	 * Get Pokemon attack
	 * @return int
	 */
	public int getAttack() {
		return pokemonAttack;
	}
	
}
