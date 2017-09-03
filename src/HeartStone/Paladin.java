package HeartStone;

/**
 * Paladin card, buffs and heals, overrides special cases.
 * @author Nicolas Escudero
 *
 */
public class Paladin extends AbstractCard {

	public Paladin(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Paladin to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByPaladin(this);}
	}
	
	/**
	 * Action done by a Knight to the Paladin, special interaction half damage.
	 * @param k an instance of the class Knight.
	 */
	@Override
	public void ActionByKnight(Knight k) {
		this.receiveDamage((int) k.getAttack()/2);
	}
	
	/**
	 * Action done by a Mage to the Paladin, special interaction double damage.
	 * @param m an instance of the class Mage.
	 */
	@Override
	public void ActionByMage(Mage m) {
		this.receiveDamage(2*m.getAttack());
	}
}
