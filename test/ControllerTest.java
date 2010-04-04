import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.BorderLayout;

import org.junit.Before;
import org.junit.Test;

import ui.vision.Vision;

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
	isTheSuperLinker() {
		assertEquals(controller.getInventory(), 
				controller.getVisionFrame().getWoodCountFormFrame().getWoodCountForm().getListener());
		assertEquals(controller.getInventory(), 
				controller.getVisionFrame().getWoodCountListFrame().getWoodCountList().getList().getModel());
		assertEquals(controller, controller.getVisionToolBar().getListener());
	}
	
	@Test public void
	actuallyActivateTheGivenVision() {
		Vision visionMock = mock(Vision.class);
		
		controller.activateVision(visionMock);
		verify(visionMock).activateVisionIn(controller.getVisionFrame());
	}
	
}
