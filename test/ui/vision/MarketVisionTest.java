package ui.vision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ui.VisionFrame;


public class MarketVisionTest {

	private MarketVision marketVision;
	
	@Before public void
	setUp() {
		marketVision = new MarketVision();
	}
	
	@Test public void
	activationSpecifications() {
		VisionFrame visionFrame = new VisionFrame();
		marketVision.activateVisionIn(visionFrame);
		
		assertFalse(visionFrame.getWoodCountFormFrame().isVisible());
		assertTrue(visionFrame.getWoodCountListFrame().isVisible());
		assertEquals(20, visionFrame.getWoodCountListFrame().getX());
	}
}
