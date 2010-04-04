package ui.request;

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



public class WoodRequestListTest {

	private WoodRequestList woodRequestList;
	
	@Before public void
	setUp() {
		woodRequestList = new WoodRequestList();
	}
	
	@Test public void
	shouldBeAJPanel() {
		assertTrue(woodRequestList instanceof JPanel);
	}
	
	@Test public void
	shouldContainARequestList() {
		Component list = woodRequestList.getComponent(0);
		assertNotNull(list); 
		assertEquals(JList.class, list.getClass());
		JList woodCountList = (JList) list;
		assertEquals(200, woodCountList.getPreferredSize().getWidth(), 0);
		assertEquals(300, woodCountList.getPreferredSize().getHeight(), 0);
	}
	
	@Test public void
	displaysTheGivenModel() {
		ListModel listModel = mock(ListModel.class);
		woodRequestList.setData(listModel);
		
		assertEquals(listModel, woodRequestList.getList().getModel());
	}
}
