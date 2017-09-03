package HeartStone;

/**
 * Shaman class, debuffer and minor damage dealer, overrides special interactions.
 * @author Nicolas Escudero
 *
 */
public class Shaman extends AbstractCard {

	public Shaman(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Shaman to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByShaman(this);}
	}
	
	/**
	 * Action done by a Hunter to the Shaman, special interaction double damage.
	 * @param h an instance of the class Hunter.
	 */
	@Override
	public void ActionByHunter(Hunter h) {
		this.receiveDamage(2*h.getAttack());
	}
}
