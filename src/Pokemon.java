
public class Pokemon {
	
	private String pokemonName;
	private String pokemonType;
	
	Move pokemonMoveOne;
	
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
	public Pokemon(String name, String type, Move moveOne, int healthpoints, int attack, int defense, int speed) {
		this.pokemonName = name;
		this.pokemonType = type;
		this.pokemonMoveOne = moveOne;
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
	 * Set Pokemon attack
	 */
	public void setAttack(int attack) {
		this.pokemonAttack = attack;
	}
	
	/**
	 * Get Pokemon attack
	 * @return int
	 */
	public int getAttack() {
		return pokemonAttack;
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
	
	public static int calculateStats (Pokemon pokemon) {
		
		int stats;
		int hp = pokemon.getHealthPoints();
		int attack = pokemon.getAttack();
		int defense = pokemon.getDefense();
		int speed = pokemon.getSpeed();
		
		// ((2 * basiswert + dv + fp/4) * level / 100 + 5) * wesen
		stats = (2 * base) *  level / 100 + 5;
		
		// (2 * basiswert + dv + fp/4 + 100) * level / 100 + 10
		statshp = (2 * base + 100) *  level / 100 + 10;
		
		return stats;
	}
}
