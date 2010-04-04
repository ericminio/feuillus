package ui;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JDesktopPane;

import org.junit.Before;
import org.junit.Test;

import ui.designation.WoodCountFormFrame;
import ui.designation.WoodCountListFrame;
import ui.request.WoodRequestListFrame;



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
		assertTrue(visionFrame.getAllFrames()[0] instanceof WoodCountFormFrame);
	}
	
	@Test public void
	shouldContainAWoodCountList() {
		assertTrue(visionFrame.getAllFrames()[1] instanceof WoodCountListFrame);
	}
	
	@Test public void
	shouldContainAWoodRequestList() {
		assertTrue(visionFrame.getAllFrames()[2] instanceof WoodRequestListFrame);
	}
	
}
