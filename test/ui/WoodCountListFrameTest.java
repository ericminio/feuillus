package ui;

import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JInternalFrame;

import org.junit.Before;
import org.junit.Test;


public class WoodCountListFrameTest {

	private WoodCountListFrame inventoryFrame;
	
	@Before public void
	setUp() {
		inventoryFrame = new WoodCountListFrame();
	}
	
	@Test public void
	shouldBeAJnternalFrame() {
		assertTrue(inventoryFrame instanceof JInternalFrame);
	}
	
	@Test public void
	shouldBebigEnoughWhenShowed() {
		Dimension size = inventoryFrame.getSize();
		assertTrue(size.getWidth() > 0);
		assertTrue(size.getHeight() > 0);
	}
	
	@Test public void
	shouldContainWoodCountList() {
		Component component = inventoryFrame.getContentPane().getComponent(0);
		assertTrue(component instanceof WoodCountList);
	}

}
