package HeartStone;

/**
 * Warlock card, damage dealer, overrides special interactions.
 * @author Nicolas Escudero
 *
 */
public class Warlock extends AbstractCard {

	public Warlock(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Warlock to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByWarlock(this);}
	}
	
	/**
	 * Action done by a Healer to the Warlock, special interaction Healer deals damage.
	 * @param h an instance of the class Healer.
	 */
	@Override
	public void ActionByHealer(Healer h) {
		this.receiveDamage(h.getAttack());
	}
	
	/**
	 * Action done by a Shaman to the Warlock, special interaction double debuff and damage.
	 * @param s an instance of the class Shaman.
	 */
	@Override
	public void ActionByShaman(Shaman s) {
		this.attackVariation((int) -2*s.getAttack()/3);
		this.receiveDamage((int) 2*s.getAttack()/3);
	}
	
}
