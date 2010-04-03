package ui;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import org.junit.Before;
import org.junit.Test;

public class WoodCountListTest {

	private WoodCountList woodCountList;
	
	@Before public void
	setUp() {
		woodCountList = new WoodCountList();
	}
	
	@Test public void
	shouldBeAJPanel() {
		assertTrue(woodCountList instanceof JPanel);
	}
	
	@Test public void
	shouldContainAInventoryList() {
		Component list = woodCountList.getComponent(0);
		assertNotNull(list); 
		assertEquals(JList.class, list.getClass());
		JList woodCountList = (JList) list;
		assertEquals(200, woodCountList.getPreferredSize().getWidth(), 0);
		assertEquals(300, woodCountList.getPreferredSize().getHeight(), 0);
	}
	
	@Test public void
	displaysTheGivenModel() {
		ListModel listModel = mock(ListModel.class);
		woodCountList.setData(listModel);
		
		assertEquals(listModel, woodCountList.getList().getModel());
	}
}
