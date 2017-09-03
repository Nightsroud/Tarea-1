package HeartStone;

/**
 * Mage card, damage dealer, overrides special cases.
 * @author Nicolas Escudero
 *
 */
public class Mage extends AbstractCard {

	public Mage(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Mage to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByMage(this);}
	}
	
	/**
	 * Action done by an Assassin to the Mage, special interaction double damage.
	 * @param a an instance of the class Assassin.
	 */
	@Override
	public void ActionByAssassin(Assassin a) {
		this.receiveDamage(2*a.getAttack());
	}
	
	/**
	 * Action done by a Warlock to the Mage, special interaction half damage.
	 * @param w an instance of the class Warlock.
	 */
	@Override
	public void ActionByWarlock(Warlock w) {
		this.receiveDamage(w.getAttack()/2);
	}
}
