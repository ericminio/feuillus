package ui;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JDesktopPane;

import org.junit.Before;
import org.junit.Test;

import ui.designation.WoodCountFormFrame;
import ui.designation.WoodCountListFrame;
import ui.request.WoodRequestListFrame;
import ui.statistics.StatisticFrame;



public class VisionFrameTest {

	private VisionFrame visionFrame;
	
	@Before public void
	setUp() {
		visionFrame = new VisionFrame();
	}
	
	@Test public void
	shouldBeADesktopPanel() {
		assertTrue(visionFrame instanceof JDesktopPane);
	}
	
	@Test public void
	shouldBeBig() {
		assertEquals(700, visionFrame.getSize().getWidth(), 0); 
		assertEquals(500, visionFrame.getSize().getHeight(), 0);
	}
	
	@Test public void
	shouldContainAWoodCountForm() {
		assertEquals(WoodCountFormFrame.class, visionFrame.getAllFrames()[0].getClass());
	}
	
	@Test public void
	shouldContainAWoodCountList() {
		assertEquals(WoodCountListFrame.class, visionFrame.getAllFrames()[1].getClass());
	}
	
	@Test public void
	shouldContainAWoodRequestList() {
		assertEquals(WoodRequestListFrame.class, visionFrame.getAllFrames()[2].getClass());
	}
	
	@Test public void
	shouldContainAStatisticList() {
		assertEquals(StatisticFrame.class, visionFrame.getAllFrames()[3].getClass());
	}
	
}
