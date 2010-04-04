package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.ListModel;

import org.junit.Before;
import org.junit.Test;


public class WoodRequestsTest {

	private WoodRequests woodRequests;
	
	@Before public void
	setUp() {
		woodRequests = new WoodRequests();
	}
	
	@Test public void
	canBeUsedAsListModel() {
		assertTrue(woodRequests instanceof ListModel);
	}
	
	@Test public void
	startWithStaticValues() {
		assertEquals(5, woodRequests.getSize());
	}
}
