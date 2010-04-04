package ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ui.vision.CounterVision;
import ui.vision.MarketVision;


public class VisionToolBarTest {

	private VisionToolBar visionToolBar;
	
	@Before public void 
	setUp() {
		visionToolBar = new VisionToolBar();
	}
	
	@Test public void
	shouldBeAJToolBar() {
		assertTrue(visionToolBar instanceof JToolBar);
	}
	
	@Test public void
	visualSpecifications() {
		assertFalse(visionToolBar.isFloatable());
		assertEquals(FlowLayout.class, visionToolBar.getLayout().getClass());
	}
	
	@Test public void
	shouldContainDifferentVisionsButtons() {
		Component[] components = visionToolBar.getComponents();
		assertEquals(2, components.length);
	}
	
	@Test public void
	counterButtonSpecifications() {
		JButton counterButton = (JButton) visionToolBar.getComponents()[0];
		assertEquals("Designation", counterButton.getText());
	}
	
	@Test public void
	commercialButtonSpecifications() {
		JButton commercialButton = (JButton) visionToolBar.getComponents()[1];
		assertEquals("Vente", commercialButton.getText());
	}
	
	@Test public void
	canRegisterAToolBarListener() {
		VisionToolBarListener listener = mock(VisionToolBarListener.class);
		visionToolBar.register(listener);
		assertEquals(listener, visionToolBar.getListener());
	}
	
	@Test public void
	notifyListenerWhenCounterButtonIsUsed() {
		VisionToolBarListener listener = mock(VisionToolBarListener.class);
		visionToolBar.register(listener);
		visionToolBar.counterButtonClicked();
		verify(listener).activateVision(Mockito.any(CounterVision.class));
	}
	
	@Test public void
	notifyListenerWhenMarketButtonIsUsed() {
		VisionToolBarListener listener = mock(VisionToolBarListener.class);
		visionToolBar.register(listener);
		visionToolBar.marketButtonClicked();
		verify(listener).activateVision(Mockito.any(MarketVision.class));
	}
	
	@Test public void
	canLiveWithoutListener() {
		visionToolBar.counterButtonClicked();
		visionToolBar.marketButtonClicked();
	}
	
}
