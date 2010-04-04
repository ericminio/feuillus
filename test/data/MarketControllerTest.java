package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import javax.swing.event.ListSelectionListener;

import org.junit.Before;
import org.junit.Test;


public class MarketControllerTest {

	private MarketController marketController;
	
	@Before public void
	setUp() {
		marketController = new MarketController();
	}
	
	@Test public void
	knowsTheOffersAndRequests() {
		AvailableWoods woods = mock(AvailableWoods.class);
		WoodRequests requests = mock(WoodRequests.class);
		marketController.setAvailableWoods(woods);
		marketController.setWoodRequests(requests);
		assertEquals(woods, marketController.getAvailableWoods());
		assertEquals(requests, marketController.getWoodRequests());
	}
	
	@Test public void
	canListenToSelectionListenerOfAList() {
		assertTrue(marketController instanceof ListSelectionListener);
	}
	
	@SuppressWarnings("serial")
	@Test public void
	removeItemsWhenSelectedItemAreEqualsInBothList() {
		marketController.setAvailableWoods(new AvailableWoods(){{removeAllElements();
			addElement("200m3 chene");
		}});
		marketController.setWoodRequests(new WoodRequests(){{removeAllElements();
			addElement("200m3 chene");
		}});
		marketController.setAvailableWoodSelected(0);
		marketController.setWoodRequestSelected(0);
		assertEquals(0, marketController.getAvailableWoods().getSize());
		assertEquals(0, marketController.getWoodRequests().getSize());
	}
}
