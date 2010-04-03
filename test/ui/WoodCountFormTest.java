package ui;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

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
	shouldContainAButton() {
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
	
	
	
}
