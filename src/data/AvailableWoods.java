package data;

import javax.swing.DefaultListModel;

import ui.designation.WoodCountFormListener;

@SuppressWarnings("serial")
public class AvailableWoods extends DefaultListModel implements WoodCountFormListener {

	public void saveWoodCount(String designation) {
		addElement(designation);
	}

}
