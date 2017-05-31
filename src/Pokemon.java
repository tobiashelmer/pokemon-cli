
public class Pokemon {
	
	private String pokemonName;
	private String pokemonType;
	
	private String pokemonAttackOne;
	private String pokemonAttackTwo;
	private String pokemonAttackThree;
	private String pokemonAttackFour;

	
	private int pokemonHealthPoints;
	private int pokemonDefense;
	private int pokemonSpeed;
	private int pokemonAttack;
	
	
	/**
	 * Constructor
	 */
	public Pokemon(String name, String type, String attackOne, String attackTwo, String attackThree, String attackFour, int hp, int def, int spd, int atk) {
		this.pokemonName = name;
		this.pokemonType = type;
		this.pokemonAttackOne = attackOne;
		this.pokemonAttackTwo = attackTwo;
		this.pokemonAttackThree = attackThree;
		this.pokemonAttackFour = attackFour;
		this.pokemonHealthPoints = hp;
		this.pokemonDefense = def;
		this.pokemonSpeed = spd;
		this.pokemonAttack = atk;
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
	 * Get Pokemon health points
	 * @return String
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
