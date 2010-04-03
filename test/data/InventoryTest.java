package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.ListModel;

import org.junit.Before;
import org.junit.Test;

import ui.WoodCountFormListener;


public class InventoryTest {

	private Inventory inventory;
	
	@Before public void
	setUp() {
		inventory = new Inventory();
		assertEquals(0, inventory.getSize());
	}
	
	@Test public void
	canBeUsedAsListModel() {
		assertTrue(inventory instanceof ListModel);
	}
	
	@Test public void
	canBeUsedAsWoodCountFormListener() {
		assertTrue(inventory instanceof WoodCountFormListener);
	}
	
	@Test public void
	canStoreADataAndProvideIt() {
		inventory.saveWoodCount("wood");
		assertEquals(1, inventory.getSize());
		assertEquals("wood", inventory.getElementAt(0));
	}
	
	@Test public void
	canStoreSeveralTimeTheSameValue() {
		inventory.saveWoodCount("wood");
		inventory.saveWoodCount("wood");
		assertEquals(2, inventory.getSize());
		assertEquals("wood", inventory.getElementAt(0));
		assertEquals("wood", inventory.getElementAt(1));
	}
	
}
