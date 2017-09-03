package HeartStone.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import HeartStone.Assassin;
import HeartStone.Druid;
import HeartStone.Healer;
import HeartStone.Hunter;
import HeartStone.ICard;
import HeartStone.Knight;
import HeartStone.Mage;
import HeartStone.Paladin;
import HeartStone.Shaman;
import HeartStone.Warlock;

/**
 * Test for Heart Stone.
 * @author Nicolas Escudero
 *
 */
public class HeartTest {
	private ICard Assassin, Druid, Healer, Hunter, Knight, Mage, Paladin, Shaman, Warlock;
	
	/**
	 * Set up for every test.
	 */
	@Before
	public void setUp() {
		Assassin = new Assassin("Valera", 40, 10);
		Druid = new Druid("Badfurion", 40, 8);
		Healer = new Healer("Andyn", 40, 10);
		Hunter = new Hunter("Raxar", 40, 8);
		Knight = new Knight("Gurrosh", 40, 6);
		Mage = new Mage("Gina", 40, 7 );
		Paladin = new Paladin("Oter", 40, 9);
		Shaman = new Shaman("Drall", 40, 9);
		Warlock = new Warlock("Gal'Din",40, 8);
	}
	
	/**
	 * Test for damage dealers with no special interactions.
	 */
	@Test
	public void SimpleDamageTest() {
		Mage.Action(Knight);	
		Hunter.Action(Assassin);
		Assassin.Action(Warlock);
		Warlock.Action(Hunter);
		Knight.Action(Mage);
		assertEquals(Knight.getDamage(), 7);
		assertEquals(Assassin.getDamage(), 8);
		assertEquals(Warlock.getDamage(), 10);
		assertEquals(Hunter.getDamage(), 8);
		assertEquals(Mage.getDamage(), 6);
	}
	
	/**
	 * Test for damage dealers and other damage in special interactions.
	 */
	@Test
	public void SpecialDamageTest() {
		Healer.Action(Warlock);
		Assassin.Action(Healer);
		Assassin.Action(Knight);
		Assassin.Action(Mage);
		Warlock.Action(Assassin);
		Warlock.Action(Mage);
		Shaman.Action(Druid);
		Shaman.Action(Warlock);
		Druid.Action(Hunter);
		Mage.Action(Hunter);
		Mage.Action(Paladin);
		Hunter.Action(Knight);
		Hunter.Action(Shaman);
		Knight.Action(Paladin);
		assertEquals(Warlock.getDamage(), 16);
		assertEquals(Healer.getDamage(), 20);
		assertEquals(Knight.getDamage(), 21);
		assertEquals(Mage.getDamage(), 24);
		assertEquals(Assassin.getDamage(), 16);
		assertEquals(Druid.getDamage(), 6);
		assertEquals(Hunter.getDamage(), 15);
		assertEquals(Paladin.getDamage(), 17);
		assertEquals(Shaman.getDamage(), 16);
	}
	
	/**
	 * Test for regular heals, can't revive cards and no over heal.
	 */
	@Test
	public void DamageLifeHealing() {
		Assassin.Action(Mage);
		Assassin.Action(Mage);
		assertFalse(Mage.isAlive());
		Healer.Action(Mage);
		assertFalse(Mage.isAlive());
		Paladin.Action(Mage);
		assertFalse(Mage.isAlive());
		Assassin.Action(Shaman);
		assertEquals(Shaman.getDamage(), 10);
		Healer.Action(Shaman);
		assertEquals(Shaman.getDamage(), 5);
		Paladin.Action(Shaman);
		assertEquals(Shaman.getDamage(), 2);
		Healer.Action(Druid);
		assertEquals(Druid.getDamage(), 0);
		Paladin.Action(Druid);
		assertEquals(Druid.getDamage(), 0);
	}
	
	/**
	 * Test for regular buffing and debuffing with special interactions.
	 */
	@Test
	public void BuffingDebuffing() {
		Druid.Action(Assassin);
		assertEquals(Assassin.getAttack(), 14);
		assertEquals(Assassin.getDamage(), 0);
		Druid.Action(Knight);
		assertEquals(Knight.getAttack(), 14);
		assertEquals(Knight.getDamage(), 4);
		Shaman.Action(Warlock);
		assertEquals(Warlock.getAttack(), 2);
		assertEquals(Warlock.getDamage(), 6);
		Shaman.Action(Druid);
		assertEquals(Druid.getAttack(), 2);
		assertEquals(Druid.getDamage(), 6);
		Shaman.Action(Hunter);
		assertEquals(Hunter.getAttack(), 5);
		assertEquals(Hunter.getDamage(), 3);
		Paladin.Action(Healer);
		assertEquals(Healer.getAttack(), 16);
		Paladin.Action(Hunter);
		assertEquals(Hunter.getAttack(), 8);
		assertEquals(Hunter.getDamage(), 0);
		Paladin.Action(Druid);
		assertEquals(Druid.getAttack(), 8);
		assertEquals(Druid.getDamage(), 0);
	}
	
	/**
	 * Test for no self action.
	 */
	@Test
	public void SelfAction() {
		Assassin.Action(Assassin);
		assertEquals(Assassin.getDamage(), 0);
		Druid.Action(Druid);
		assertEquals(Druid.getAttack(), 8);
		assertEquals(Druid.getDamage(), 0);
		Assassin.Action(Healer);
		Healer.Action(Healer);
		assertEquals(Healer.getDamage(), 2*Assassin.getAttack());
		Hunter.Action(Hunter);
		assertEquals(Hunter.getDamage(), 0);
		Knight.Action(Knight);
		assertEquals(Knight.getDamage(), 0);
		Mage.Action(Mage);
		assertEquals(Mage.getDamage(), 0);
		Assassin.Action(Paladin);
		Paladin.Action(Paladin);
		assertEquals(Paladin.getDamage(), Assassin.getAttack());
		assertEquals(Paladin.getAttack(), 9);
		Shaman.Action(Shaman);
		assertEquals(Shaman.getDamage(), 0);
		assertEquals(Shaman.getAttack(), 9);
		Warlock.Action(Warlock);
		assertEquals(Warlock.getDamage(), 0);
	}
}