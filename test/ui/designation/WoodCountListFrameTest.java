package ui.designation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JInternalFrame;

import org.junit.Before;
import org.junit.Test;



public class WoodCountListFrameTest {

	private WoodCountListFrame woodCountListFrame;
	
	@Before public void
	setUp() {
		woodCountListFrame = new WoodCountListFrame();
	}
	
	@Test public void
	shouldBeAJnternalFrame() {
		assertTrue(woodCountListFrame instanceof JInternalFrame);
	}
	
	@Test public void
	shouldBebigEnoughWhenShowed() {
		Dimension size = woodCountListFrame.getSize();
		assertTrue(size.getWidth() > 0);
		assertTrue(size.getHeight() > 0);
	}
	
	@Test public void
	shouldContainWoodCountList() {
		Component component = woodCountListFrame.getContentPane().getComponent(0);
		assertTrue(component instanceof WoodCountList);
	}

	@Test public void
	hasATitle() {
		assertEquals("Bois dispo", woodCountListFrame.getTitle());
	}
}
