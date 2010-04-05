package ui.designation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class WoodCountFormTest {

	private WoodCountForm woodCountForm;
	
	@Before public void
	setUp() {
		woodCountForm = new WoodCountForm();
	}
	
	@Test public void
	shouldBeAJPanel() {
		assertTrue(woodCountForm instanceof JPanel);
	}
	
	@Test public void
	shouldContainAnEssenceField() {
		Component essenceComponent = woodCountForm.getComponent(0);
		assertNotNull(essenceComponent); 
		assertEquals(JTextField.class, essenceComponent.getClass());
		JTextField essenceField = (JTextField) essenceComponent;
		assertEquals(200, essenceField.getPreferredSize().getWidth(), 0);
		assertEquals(20, essenceField.getPreferredSize().getHeight(), 0);
	}
	
	@Test public void
	shouldContainASaveButton() {
		Component button = woodCountForm.getComponent(1);
		assertNotNull(button);
		assertEquals(JButton.class, button.getClass());
		JButton saveButton = (JButton) button;
		assertEquals("Ya ça comme bois", saveButton.getText());
	}
	
	@Test public void
	canRegisterAListener() {
		WoodCountFormListener listener = mock(WoodCountFormListener.class);
		woodCountForm.register(listener);
		assertEquals(listener, woodCountForm.getListener());
	}
	
	@Test public void
	listenerIsNotifiedWhenButtonIsClicked() {
		WoodCountFormListener listener = mock(WoodCountFormListener.class);
		woodCountForm.register(listener);
		woodCountForm.getEssenceField().setText("chene");
		woodCountForm.saveButtonClicked();
		verify(listener).saveWoodCount("chene");
	}
	
	@Test public void
	canLiveWithoutListener() {
		woodCountForm.saveButtonClicked();
	}
	
	@Test public void
	notifyListenerOnlyIfAWoodIsTyped() {
		WoodCountFormListener listener = mock(WoodCountFormListener.class);
		woodCountForm.register(listener);
		woodCountForm.getEssenceField().setText(" ");
		
		woodCountForm.saveButtonClicked();
		verify(listener, never()).saveWoodCount(Mockito.any(String.class));
	}
	
	@Test public void
	inputFieldIsClearedAfterSave() {
		woodCountForm.getEssenceField().setText(" ");
		woodCountForm.saveButtonClicked();
		assertEquals("", woodCountForm.getEssenceField().getText());
	}
	
	@Test public void
	hasAVolumeInputShorcut() {
		woodCountForm.getEssenceField().setText("might contain something");
		woodCountForm.setVolume("100m3");
		assertEquals("100m3 ", woodCountForm.getEssenceField().getText());
	}
	
	@Test public void
	hasAWoodInputShortcut() {
		woodCountForm.setVolume("100m3");
		woodCountForm.setWood("chene");
		assertEquals("100m3 chene", woodCountForm.getEssenceField().getText());
	}
	
	@Test public void
	layoutIsGrid() {
		assertEquals(GridLayout.class, woodCountForm.getLayout().getClass());
	}
	
	@Test public void
	containsVolumeShorcutButtons() {
		String[] expectedLabels = new String[] {"100m3", "200m3", "300m3"};
		
		Component[] components = woodCountForm.getComponents();
		List<JButton> buttons = new ArrayList<JButton>();
		for (int i=0; i<components.length; i++) {
			if (components[i] instanceof JButton) {
				if (components[i].getName()!=null && components[i].getName().equalsIgnoreCase("volume")) {
					buttons.add((JButton)components[i]);
				}
			}
		}
		assertEquals(expectedLabels.length, buttons.size());
		for (int i=0; i<buttons.size(); i++) {
			assertEquals(expectedLabels[i], buttons.get(i).getText());
		}
	}
	
	@Test public void
	containsWoodShorcutButtons() {
		String[] expectedLabels = new String[] {"chene", "hetre", "bouleau", "cerisier"};
		
		Component[] components = woodCountForm.getComponents();
		List<JButton> buttons = new ArrayList<JButton>();
		for (int i=0; i<components.length; i++) {
			if (components[i] instanceof JButton) {
				if (components[i].getName()!=null && components[i].getName().equalsIgnoreCase("wood")) {
					buttons.add((JButton)components[i]);
				}
			}
		}
		assertEquals(expectedLabels.length, buttons.size());
		for (int i=0; i<buttons.size(); i++) {
			assertEquals(expectedLabels[i], buttons.get(i).getText());
		}
	}
	
	
	
}
