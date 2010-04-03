package ui;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JInternalFrame;

import org.junit.Before;
import org.junit.Test;



public class WoodCountFrameTest {

	private WoodCountFormFrame woodCountFrame;
	
	@Before public void
	setUp() {
		woodCountFrame = new WoodCountFormFrame();
	}
	
	@Test public void
	shouldBeAJnternalFrame() {
		assertTrue(woodCountFrame instanceof JInternalFrame);
	}
	
	@Test public void
	shouldBebigEnoughWhenShowed() {
		Dimension size = woodCountFrame.getSize();
		assertTrue(size.getWidth() > 0);
		assertTrue(size.getHeight() > 0);
	}

	@Test public void
	shouldContainWoodCountForm() {
		Component component = woodCountFrame.getContentPane().getComponent(0);
		assertTrue(component instanceof WoodCountForm);
	}
	
}
