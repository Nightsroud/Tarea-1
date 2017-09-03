package HeartStone;

/**
 * Hunter card, damage dealer, overrides special cases.
 * @author Nicolas Escudero
 *
 */
public class Hunter extends AbstractCard {

	public Hunter(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Hunter to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByHunter(this);}
	}
	
	/**
	 * Action done by a Druid to the Hunter, special interaction only receive the damage portion.
	 * @param d an instance of the class Druid.
	 */
	@Override
	public void ActionByDruid(Druid d) {
		this.receiveDamage((int) d.getAttack()/2);
	}
	
	/**
	 * Action done by a Mage to the Hunter, special interaction double damage.
	 * @param m an instance of the class Mage.
	 */
	@Override
	public void ActionByMage(Mage m) {
		this.receiveDamage(2*m.getAttack());
	}
}
