package ui.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.awt.Dimension;

import javax.swing.ListModel;

import org.junit.Before;
import org.junit.Test;


public class StatisticFrameTest {

	private StatisticFrame statisticFrame;
	
	@Before public void setUp() {
		statisticFrame = new StatisticFrame();
	}
	
	@Test public void
	title() {
		assertEquals("Statistiques", statisticFrame.getTitle());
	}
	
	@Test public void
	shouldBebigEnoughWhenShowed() {
		Dimension size = statisticFrame.getSize();
		assertTrue(size.getWidth() > 0);
		assertTrue(size.getHeight() > 0);
	}
	
	@Test public void
	listSpecifications() {
		Dimension size = statisticFrame.getStatisticList().getPreferredSize();
		assertTrue(size.getWidth() == 150);
		assertTrue(size.getHeight() == 200);
		assertFalse(statisticFrame.getStatisticList().isEnabled());
	}
	
	@Test public void
	dataCanBeSetExternally() {
		ListModel listModel = mock(ListModel.class);
		statisticFrame.setStatistics(listModel);
		assertEquals(listModel, statisticFrame.getStatisticList().getModel());
	}
}
