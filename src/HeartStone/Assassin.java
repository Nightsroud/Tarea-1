package HeartStone;

/**
 * Assassin card, damage dealer, overrides special interactions. 
 * @author Nicolas Escudero
 *
 */
public class Assassin extends AbstractCard {
	
	public Assassin(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Assassin to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByAssassin(this);}
	}
	
	/**
	 * Action done by a Druid to the Assassin, special interaction only buff part but half.
	 * @param d an instance of the class Druid.
	 */
	@Override
	public void ActionByDruid(Druid d) {
		this.attackVariation((int) d.getAttack()/2);
	}
	
	/**
	 * Action done by a Warlock to the Assassin, special interaction double damage.
	 * @param w an instance of the class Warlock.
	 */
	@Override
	public void ActionByWarlock(Warlock w) {
		this.receiveDamage(2*w.getAttack());
	}

}
