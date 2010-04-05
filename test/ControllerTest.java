import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.BorderLayout;

import org.junit.Before;
import org.junit.Test;

import ui.VisionFrame;
import ui.VisionToolBar;
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
		assertNotNull(controller.getVisionToolBar());
		
		assertNotNull(controller.getMainFrame());
		assertTrue(controller.getMainFrame().getLayout() instanceof BorderLayout);
		
		assertEquals(VisionFrame.class, controller.getMainFrame().getComponents()[0].getClass());
		assertEquals(VisionToolBar.class, controller.getMainFrame().getComponents()[1].getClass());
		
		assertNotNull(controller.getAvailableWoods());
		assertNotNull(controller.getWoodRequests());
		assertNotNull(controller.getMarketController());
		assertNotNull(controller.getRequestRandomizer());
	}
	
	@Test public void
	isTheSuperLinker() {
		assertEquals(controller, controller.getVisionToolBar().getListener());
		assertEquals(controller.getAvailableWoods(), 
				controller.getVisionFrame().getWoodCountFormFrame().getWoodCountForm().getListener());
		assertEquals(controller.getAvailableWoods(), 
				controller.getVisionFrame().getWoodCountListFrame().getWoodCountList().getList().getModel());
		
		assertEquals(controller.getWoodRequests(),
				controller.getVisionFrame().getWoodRequestListFrame().getWoodRequestList().getList().getModel());
		
		assertEquals(controller.getAvailableWoods(), controller.getMarketController().getAvailableWoods());
		assertEquals(controller.getWoodRequests(), controller.getMarketController().getWoodRequests());
		assertEquals(controller.getMarketController(), 
				controller.getVisionFrame().getWoodCountListFrame().getWoodCountList().getList().getListSelectionListeners()[0]);
		assertEquals(controller.getMarketController(), 
				controller.getVisionFrame().getWoodRequestListFrame().getWoodRequestList().getList().getListSelectionListeners()[0]);
		
		assertEquals(controller.getWoodRequests(), controller.getRequestRandomizer().getWoodRequests());
	}
	
	@Test public void
	actuallyActivateTheGivenVision() {
		Vision visionMock = mock(Vision.class);
		
		controller.activateVision(visionMock);
		verify(visionMock).activateVisionIn(controller.getVisionFrame());
	}
	
}
