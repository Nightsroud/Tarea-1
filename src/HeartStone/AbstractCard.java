package HeartStone;

/**
 * Abstract class for the cards, implements interface ICard.
 * @author Nicolas Escudero
 *
 */
public abstract class AbstractCard implements ICard {
	
	protected String Name;
	protected int lifePoints;
	protected int Damage = 0;
	protected int Attack;
	
	/**
	 * Card Constructor, in case of negative values these are changed to 0.
	 * @param n: Name of the card
	 * @param lp: Life points of the card
	 * @param a: Attack points of the card
	 */
	public AbstractCard(String n, int lp, int a) {
		Name = n;
		lifePoints = Math.max(lp, 0);
		Attack = Math.max(a, 0);
	}
	
	/**
	 * Gets the name of the card.
	 * @return returns the String variable Name
	 */
	
	public String getName() {
		return Name;
	}
	
	/**
	 * Gets the attack value of the card.
	 * @return returns the int variable Attack
	 */

	public int getAttack() {
		return Attack;
	}
	
	/**
	 * Gets the amount of damage received by the card.
	 * @return the int variable Damage
	 */

	public int getDamage() {
		return Damage;
	}
	
	/**
	 * Gets the total life points of the card.
	 * @return the int variable lifePoints
	 */
	
	public int getLifePoints() {
		return lifePoints;
	}
	
	/**
	 * Tells you if the card is alive or not in a boolean form.
	 * @return the truth value of the statement "this card's damage is lower than it's life points"
	 */
	
	public boolean isAlive() {
		return (this.getDamage() < this.getLifePoints());
	}
	
	/**
	 * Adds d damage to a card.
	 * @param d amount of damage received by the card, always positive.
	 */
	
	public void receiveDamage(int d) {
		Damage += Math.abs(d);
	}
	
	/**
	 * Reduces the damage of a card by h, if damage is less than h, then damage becomes 0.
	 * @param h amount of damage healed by the card, always positive.
	 */
	
	public void healDamage(int h) {
		if(this.isAlive()) {Damage = Math.max(this.getDamage()-Math.abs(h), 0);}
		else {System.out.println("Can't revive Cards");}
	}
	
	/**
	 * Changes the Attack value of the card.
	 * @param a amount in which the attack is changed, can be negative.
	 */
	
	public void attackVariation(int a) {
		Attack = Math.max(this.getAttack()+a, 0);
	}
	
	/**
	 * Action done by this card to the card c.
	 * @param c card in which the action is being done.
	 */

	public abstract void Action(ICard c);
	
	/**
	 * Action done to this card by an Assassin a.
	 * @param a an instance of the class Assassin.
	 */
	
	public void ActionByAssassin(Assassin a){
		this.receiveDamage(a.getAttack());
	}
	
	/**
	 * Action done to this card by a Druid d.
	 * @param d an instance of the class Druid.
	 */
	
	public void ActionByDruid(Druid d) {
		this.attackVariation(d.getAttack());
		this.receiveDamage((int) d.getAttack()/2);
	}
	
	/**
	 * Action done to this card by a Healer h.
	 * @param h an instance of the class Healer.
	 */
	
	public void ActionByHealer(Healer h) {
		this.healDamage((int) h.getAttack()/2);
	}
	
	/**
	 * Action done to this card by a Hunter h.
	 * @param h an instance of the class hunter.
	 */
	
	public void ActionByHunter(Hunter h) {
		this.receiveDamage(h.getAttack());
	}
	
	/**
	 * Action done to this card by a Knight k.
	 * @param k an instance of the class Knight.
	 */
	
	public void ActionByKnight(Knight k) {
		this.receiveDamage(k.getAttack());
	}
	
	/**
	 * Action done to this card by a Mage m.
	 * @param m an instance of the class Mage.
	 */
	
	public void ActionByMage(Mage m) {
		this.receiveDamage(m.getAttack());
	}
	
	/**
	 * Action done to this card by a Paladin p.
	 * @param p an instance of the class Paladin.
	 */
	
	public void ActionByPaladin(Paladin p) {
		this.attackVariation((int) p.getAttack()/3);
		this.healDamage((int) p.getAttack()/3);
	}
	
	/**
	 * Action done to this card by a Shaman s.
	 * @param s an instance of the class Shaman.
	 */
	
	public void ActionByShaman(Shaman s) {
		this.attackVariation((int) -s.getAttack()/3);
		this.receiveDamage((int) s.getAttack()/3);
	}
	
	/**
	 * Action done to this card by a Warlock w.
	 * @param w an instance of the class Warlock.
	 */
	
	public void ActionByWarlock(Warlock w) {
		this.receiveDamage(w.getAttack());
	}
}
