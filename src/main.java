
public class main {

	public static void main(String[] args) {
		
		//Attack Tackle = new Attack("Tackle", "Normal", 20, 20, 100);
		Attack Rankenhieb = new Attack("Rankenhieb", "Pflanze", 35, 10, 100);
		Attack Glut = new Attack("Glut", "Feuer", 40, 25, 100);

		Pokemon Bisasam = new Pokemon("Bisasam", "Pflanze", Rankenhieb, 21, 13, 10, 10);
		Pokemon Glumanda = new Pokemon("Glumanda", "Feuer", Glut, 21, 13, 10, 10);
		
		System.out.println("Vor dem Angriff: " + Glumanda.getHealthPoints());

		System.out.println("Angriff mit " + Rankenhieb.getAttackName());
		calculateDamage(Rankenhieb, Bisasam, Glumanda);
		
		System.out.println("Nach dem Angriff: " + Glumanda.getHealthPoints());
		
	}	
	
	public static int calculateDamage(Attack attack, Pokemon attacker, Pokemon defender) {
		
		int hp = defender.getHealthPoints();
		int damage = ((((2*5)/5)+2) * attack.getAttackPower() * (attacker.getAttack() / defender.getDefense()) / 50) + 2;

		defender.setHealthPoints(hp - damage);
		 
		return damage;
	}
	
}
