import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;



public class ControllerTest {

	private Controller controller;
	
	@Before public void
	setUp() {
		controller = new Controller();
	}
	
	@Test public void
	formShouldHaveAListener() {
		assertNotNull(controller.getMainFrame().getWoodCountFormFrame().getWoodCountForm().getListener());
	}
	
	@Test public void
	listShouldUseInventoryAsListModel() {
		assertEquals(controller.getInventory(), controller.getMainFrame().getWoodCountListFrame().getWoodCountList().getList().getModel());
	}
}
