public class main {
	
	public static void main(String[] args) {
		
		Move tackle = new Move("Tackle", "Normal", 20, 20, 100);
		Move rankenhieb = new Move("Rankenhieb", "Pflanze", 35, 10, 100);
		Move glut = new Move("Glut", "Feuer", 40, 25, 100);

		Pokemon bisasam = new Pokemon("Bisasam", "Pflanze", rankenhieb, 21, 13, 10, 10);
		Pokemon glumanda = new Pokemon("Glumanda", "Feuer", glut, 21, 13, 10, 10);
		
		//renderHealthBar(Glumanda);
		
		Move.calculateDamage(rankenhieb, bisasam, glumanda);				
	}	
	
	public static void choosePokemon() {
		
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
