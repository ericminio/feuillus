package ui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class WoodCountForm extends JPanel{

	private JTextField essenceField;
	private JButton saveButton;
	private WoodCountFormListener listener;
	
	public WoodCountForm() {
		addComponents();
	}
	
	protected void addComponents() {
		add(getEssenceField());
		add(getSaveButton());
	}
	
	protected JTextField getEssenceField() {
		if (essenceField == null) {
			essenceField = new JTextField();
			essenceField.setPreferredSize(new Dimension(200, 20));
		}
		return essenceField;
	}
	
	protected JButton getSaveButton() {
		if (saveButton == null) {
			saveButton = new JButton("Ya a comme bois");
			saveButton.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					saveButtonClicked();
				}
			});
		}
		return saveButton;
	}

	public void register(WoodCountFormListener listener) {
		this.listener = listener;
	}

	public WoodCountFormListener getListener() {
		return listener;
	}

	public void saveButtonClicked() {
		if (listener != null) {
			if (essenceField.getText().trim().length() > 0) {
				listener.saveWoodCount(essenceField.getText());
			} 
		}
		essenceField.setText("");
		essenceField.requestFocus();
	}
}
