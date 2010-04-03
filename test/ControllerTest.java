import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.BorderLayout;

import org.junit.Before;
import org.junit.Test;

import ui.VisionToolBarListener;

public class ControllerTest {

	private Controller controller;
	
	@Before public void
	setUp() {
		controller = new Controller();
	}
	
	@Test public void
	isTheSuperBuilder() {
		assertNotNull(controller.getVisionFrame());
		assertNotNull(controller.getInventory());
		assertNotNull(controller.getVisionToolBar());
		
		assertNotNull(controller.getMainFrame());
		assertTrue(controller.getMainFrame().getLayout() instanceof BorderLayout);
		assertEquals(2, controller.getMainFrame().getComponents().length);
	}
	
	@Test public void
	formShouldHaveAListener() {
		assertEquals(controller.getInventory(), 
				controller.getVisionFrame().getWoodCountFormFrame().getWoodCountForm().getListener());
	}
	
	@Test public void
	listShouldUseInventoryAsListModel() {
		assertEquals(controller.getInventory(), 
				controller.getVisionFrame().getWoodCountListFrame().getWoodCountList().getList().getModel());
	}
	
	@Test public void
	shouldBeTheVisionManager() {
		assertTrue(controller instanceof VisionToolBarListener);
		assertEquals(controller, controller.getVisionToolBar().getListener());
	}
	
	@Test public void
	countVisionSpecifications() {
		controller.marketVisionAsked();
		controller.counterVisionAsked();
		assertCountVision();
	}
	
	@Test public void
	countVisionIsStartingVision() {
		assertCountVision();
	}

	private void assertCountVision() {
		assertTrue(controller.getVisionFrame().getWoodCountFormFrame().isVisible());
		
		assertTrue(controller.getVisionFrame().getWoodCountListFrame().isVisible());
		assertEquals(controller.getVisionFrame().getWoodCountFormFrame().getX()
				+ controller.getVisionFrame().getWoodCountFormFrame().getWidth()
				+20, 
				controller.getVisionFrame().getWoodCountListFrame().getX());
	}
	
	@Test public void
	marketVisionSpecifications() {
		controller.counterVisionAsked();
		controller.marketVisionAsked();
		assertFalse(controller.getVisionFrame().getWoodCountFormFrame().isVisible());
		assertTrue(controller.getVisionFrame().getWoodCountListFrame().isVisible());
		assertEquals(20, controller.getVisionFrame().getWoodCountListFrame().getX());
	}
}
