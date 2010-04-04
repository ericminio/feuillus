package ui.vision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ui.VisionFrame;


public class CounterVisionTest {

	private CounterVision counterVision;
	
	@Before public void
	setUp() {
		counterVision = new CounterVision();
	}
	
	@Test public void
	activationSpecifications() {
		VisionFrame visionFrame = new VisionFrame();
		counterVision.activateVisionIn(visionFrame);
		
		assertTrue(visionFrame.getWoodCountFormFrame().isVisible());
		
		assertTrue(visionFrame.getWoodCountListFrame().isVisible());
		assertEquals(visionFrame.getWoodCountFormFrame().getX() + visionFrame.getWoodCountFormFrame().getWidth() + 20, 
				visionFrame.getWoodCountListFrame().getX());
	}
}
