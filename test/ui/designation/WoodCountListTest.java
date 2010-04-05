package ui.designation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	displaysTheGivenModel() {
		ListModel fake = mock(ListModel.class);
		woodCountList.setData(fake);
		
		assertEquals(fake, woodCountList.getList().getModel());
	}
	
	@Test public void
	scrollSpecifications() {
		JScrollPane scrollPane = woodCountList.getScrollPane();
		assertNotNull(scrollPane.getVerticalScrollBar());
		assertEquals(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, scrollPane.getVerticalScrollBarPolicy());
		assertEquals(180, scrollPane.getPreferredSize().getWidth(), 0);
		assertEquals(300, scrollPane.getPreferredSize().getHeight(), 0);
	}
}
