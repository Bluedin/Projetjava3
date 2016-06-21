package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeroTest {

	Hero hero;
	Spell spell;
	
	@Before
	public void setUp() throws Exception {
		this.hero = new Hero(1, 1);
		this.spell = new Spell(-5, -5);
	}

	@Test
	public void testGetLife() {
		assertTrue(hero.getLife());;
	}

	@Test
	public void testDie() {
		hero.die();
		assertTrue(!hero.getLife());
	}

	@Test
	public void testGetScore() {
		
		assertEquals(0, hero.getScore());;
	}

	@Test
	public void testGetHasSpell() {
		assertTrue(hero.getHasSpell());
	}

	@Test
	public void testGainSpell() {
		hero.gainSpell();
		assertTrue(hero.getHasSpell());
	}

}