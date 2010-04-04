package ui.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JInternalFrame;

import org.junit.Before;
import org.junit.Test;



public class WoodRequestListFrameTest {

	private WoodRequestListFrame woodRequestListFrame;
	
	@Before public void
	setUp() {
		woodRequestListFrame = new WoodRequestListFrame();
	}
	
	@Test public void
	shouldBeAJnternalFrame() {
		assertTrue(woodRequestListFrame instanceof JInternalFrame);
	}
	
	@Test public void
	shouldBebigEnoughWhenShowed() {
		Dimension size = woodRequestListFrame.getSize();
		assertTrue(size.getWidth() > 0);
		assertTrue(size.getHeight() > 0);
	}
	
	@Test public void
	shouldContainWoodRequestList() {
		Component component = woodRequestListFrame.getContentPane().getComponent(0);
		assertTrue(component instanceof WoodRequestList);
	}
	
	@Test public void
	hasATitle() {
		assertEquals("Demandes", woodRequestListFrame.getTitle());
	}

}
