import java.util.Random;

public class main {
	
	public static void main(String[] args) {
		
		Attack tackle = new Attack("Tackle", "Normal", 20, 20, 100);
		Attack rankenhieb = new Attack("Rankenhieb", "Pflanze", 35, 10, 100);
		Attack glut = new Attack("Glut", "Feuer", 40, 25, 100);

		Pokemon bisasam = new Pokemon("Bisasam", "Pflanze", rankenhieb, 21, 13, 10, 10);
		Pokemon glumanda = new Pokemon("Glumanda", "Feuer", glut, 21, 13, 10, 10);
		
		//renderHealthBar(Glumanda);
		
		Attack.calculateDamage(rankenhieb, bisasam, glumanda);
				
	}	
	
	public static void choosePokemon() {
		
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
