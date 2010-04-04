package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.ListModel;

import org.junit.Before;
import org.junit.Test;

import ui.designation.WoodCountFormListener;


public class AvailableWoodsTest {

	private AvailableWoods availableWoods;
	
	@Before public void
	setUp() {
		availableWoods = new AvailableWoods();
		assertEquals(0, availableWoods.getSize());
	}
	
	@Test public void
	canBeUsedAsListModel() {
		assertTrue(availableWoods instanceof ListModel);
	}
	
	@Test public void
	canBeUsedAsWoodCountFormListener() {
		assertTrue(availableWoods instanceof WoodCountFormListener);
	}
	
	@Test public void
	canStoreADataAndProvideIt() {
		availableWoods.saveWoodCount("wood");
		assertEquals(1, availableWoods.getSize());
		assertEquals("wood", availableWoods.getElementAt(0));
	}
	
	@Test public void
	canStoreSeveralTimeTheSameValue() {
		availableWoods.saveWoodCount("wood");
		availableWoods.saveWoodCount("wood");
		assertEquals(2, availableWoods.getSize());
		assertEquals("wood", availableWoods.getElementAt(0));
		assertEquals("wood", availableWoods.getElementAt(1));
	}
	
}
