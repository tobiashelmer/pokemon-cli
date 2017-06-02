import java.util.Random;

public class main {
	
	public static final double STAB_MULTIPLIER = 1.5; 
	public static final double CRIT_MULTIPLIER = 2; 

	public static void main(String[] args) {
		
		//Attack Tackle = new Attack("Tackle", "Normal", 20, 20, 100);
		Attack Rankenhieb = new Attack("Rankenhieb", "Pflanze", 35, 10, 100);
		Attack Glut = new Attack("Glut", "Feuer", 40, 25, 100);

		Pokemon Bisasam = new Pokemon("Bisasam", "Pflanze", Rankenhieb, 21, 13, 10, 10);
		Pokemon Glumanda = new Pokemon("Glumanda", "Feuer", Glut, 21, 13, 10, 10);
		
		renderHealthBar(Glumanda);
		
		calculateDamage(Rankenhieb, Bisasam, Glumanda);
				
	}	
	
	public static int calculateDamage(Attack attack, Pokemon attacker, Pokemon defender) {
		
		boolean stab = isStab(attack, attacker);
		boolean crit = isCriticalHit();
		double multiplier = 1;
		
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
		
		int damage = (int) ((((((2*5)/5)+2) * attackPower * (attackerAttack / defenderDefense) / 50) + 2) * multiplier);

		defender.setHealthPoints(hp - damage);
		
		System.out.println(attack.getAttackName() + " hat " + damage + " Schaden zugefuegt!");
		 
		return damage;
	}
	
	public static boolean isStab(Attack attack, Pokemon pokemon) {
		
		boolean stab = false;
		String attackType = attack.getAttackType();
		String pokemonType = pokemon.getType();
		
		if (attackType.equals(pokemonType)) {
			stab = true;
		}
		
		return stab;
		
	}
	
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
	
	public static void renderHealthBar(Pokemon current) {
		
		int currentHP = current.getHealthPoints();
		int maxHP = current.getMaxHealthPoints();
		
		String healthBarFirst  = "HP: xxxxxxxxxx ||";
		String healthBarSecond = "       " + currentHP + " / " + maxHP + " ||";
		String healthBarThird  = "<==============||";
		
		System.out.println(healthBarFirst);
		System.out.println(healthBarSecond);
		System.out.println(healthBarThird);

	}
}
