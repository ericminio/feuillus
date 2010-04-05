package ui.designation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WoodCountForm extends JPanel {

	private JTextField essenceField;
	private JButton saveButton;
	private WoodCountFormListener listener;
	private GridLayout grid;

	public WoodCountForm() {
		grid = new GridLayout(7, 2);
		setLayout(grid);
		addComponents();
	}

	protected void addComponents() {
		add(getEssenceField());
		add(getSaveButton());
		addVolumeButtons();
		addWoodButtons();
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

	public void setVolume(String volume) {
		essenceField.setText(volume + " ");
	}

	public void setWood(String wood) {
		essenceField.setText(essenceField.getText() + wood);
	}

	public void addVolumeButtons() {
		String[] texts = new String[] {"100m3", "200m3", "300m3"};
		for (int i = 0; i < texts.length; i++) {
			add(buildVolumeButton(texts[i]));
		}
	}

	public JButton buildVolumeButton(final String text) {
		JButton volumeButton = new JButton(text);
		volumeButton.setName("volume");
		volumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVolume(text);
			}
		});
		return volumeButton;
	}
	
	public void addWoodButtons() {
		String[] texts = new String[] {"chene", "hetre", "bouleau", "cerisier"};
		for (int i = 0; i < texts.length; i++) {
			add(buildWoodButton(texts[i]));
		}
	}

	public JButton buildWoodButton(final String text) {
		JButton woodButton = new JButton(text);
		woodButton.setName("wood");
		woodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWood(text);
			}
		});
		return woodButton;
	}
}
