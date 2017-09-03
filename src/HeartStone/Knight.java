package HeartStone;

/**
 * Knight card, damage dealer, overrides special cases.
 * @author Nicolas Escudero
 *
 */
public class Knight extends AbstractCard {

	public Knight(String n, int lp, int a) {
		super(n, lp, a);
	}
	
	/**
	 * Action done by the Knight to the card c, if itself then nothing happens but a print.
	 * @param c any card.
	 */
	@Override
	public void Action(ICard c) {
		if(c.equals(this)) {System.out.println("Can't do action on self");}
		else{c.ActionByKnight(this);}
	}
	
	/**
	 * Action done by a Hunter to the Knight, special interaction double damage.
	 * @param h an instance of the class Hunter.
	 */
	@Override
	public void ActionByHunter(Hunter h) {
		this.receiveDamage(2*h.getAttack());
	}
	
	/**
	 * Action done by an Assassin to the Knight, special interaction half damage.
	 *@param a an instance of the class Assassin.
	 */
	@Override
	public void ActionByAssassin(Assassin a){
		this.receiveDamage((int) a.getAttack()/2);
	}
}
