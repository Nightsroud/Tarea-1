package HeartStone;

/**
 * Druid card, big buffs in exchange for some damage, overrides special cases.
 * @author Nicolas Escudero
 *
 */
public class Druid extends AbstractCard {
	
	public Druid(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Druid to the card c, if itself then nothing happens but a print.
	 * @param c any card. 
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByDruid(this);}
	}
	
	/**
	 * Action done by a Paladin to the Druid, special interaction double buff and heal.
	 * @param p an instance of the class Paladin.
	 */
	@Override
	public void ActionByPaladin(Paladin p) {
		this.attackVariation((int) 2*p.getAttack()/3);
		this.healDamage((int) 2*p.getAttack()/3);
	}
	
	/**
	 * Action done by a Shaman to the Druid, special interaction double debuff and damage.
	 * @param s an instance of the class Shaman.
	 */
	@Override
	public void ActionByShaman(Shaman s) {
		this.attackVariation((int) -2*s.getAttack()/3);
		this.receiveDamage((int) 2*s.getAttack()/3);
	}
	
	
}
