package HeartStone;

/**
 * Healer Card, Heals, overrides special cases.
 * @author Nicolas Escudero
 *
 */
public class Healer extends AbstractCard {
	
	public Healer(String n, int lp, int a) {
		super(n,lp,a);
	}
	
	/**
	 * Action done by the Healer to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByHealer(this);}
	}
	
	/**
	 * Action done by an Assassin to the Healer, special interaction double damage.
	 * @param a an instance of the class Assassin.
	 */
	@Override
	public void ActionByAssassin(Assassin a) {
		this.receiveDamage(2*a.getAttack());
	}
	
	/**
	 * Action done by a Paladin to the Healer, special interaction double buff and heal.
	 * @param p an instance of the class Paladin.
	 */
	@Override
	public void ActionByPaladin(Paladin p) {
		this.attackVariation((int) 2*p.getAttack()/3);
		this.healDamage((int) 2*p.getAttack()/3);
	}
}
