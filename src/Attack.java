
public class Attack {
	
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
}