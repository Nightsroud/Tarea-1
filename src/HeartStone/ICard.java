package HeartStone;

/**
 * Interface for the cards. 
 * @author Nicolas Escudero
 *
 */

public interface ICard {
	
	public String getName();
	
	public int getAttack();
	
	public int getDamage();
	
	public boolean isAlive();
	
	public void receiveDamage(int d);
	
	public void healDamage(int h);
	
	public void attackVariation(int a);
	
	public void Action(ICard c);
	
	public void ActionByAssassin(Assassin a);
	
	public void ActionByDruid(Druid d);
	
	public void ActionByHealer(Healer h);
	
	public void ActionByHunter(Hunter h);
	
	public void ActionByKnight(Knight k);
	
	public void ActionByMage(Mage m);
	
	public void ActionByPaladin(Paladin p);
	
	public void ActionByShaman(Shaman s);
	
	public void ActionByWarlock(Warlock w);

	
	

}
