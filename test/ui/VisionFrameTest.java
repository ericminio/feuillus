package ui;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import org.junit.Before;
import org.junit.Test;



public class VisionFrameTest {

	private VisionFrame mainFrame;
	
	@Before public void
	setUp() {
		mainFrame = new VisionFrame();
	}
	
	@Test public void
	shouldBeADesktopPanel() {
		assertTrue(mainFrame instanceof JDesktopPane);
	}
	
	@Test public void
	shouldBeBig() {
		assertEquals(700, mainFrame.getSize().getWidth(), 0); 
		assertEquals(500, mainFrame.getSize().getHeight(), 0);
	}
	
	@Test public void
	shouldContainAWoodCountForm() {
		JInternalFrame woodCountFormFrame = mainFrame.getAllFrames()[0];
		assertTrue(woodCountFormFrame instanceof WoodCountFormFrame);
	}
	
	@Test public void
	shouldContainAWoodCountList() {
		JInternalFrame woodCountListFrame = mainFrame.getAllFrames()[1];
		assertTrue(woodCountListFrame instanceof WoodCountListFrame);
	}
	
	@Test public void
	shouldContainAVisionToolBar() {
		JInternalFrame woodCountListFrame = mainFrame.getAllFrames()[1];
		assertTrue(woodCountListFrame instanceof WoodCountListFrame);
	}
}
