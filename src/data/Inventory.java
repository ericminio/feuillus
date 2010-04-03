package data;

import javax.swing.DefaultListModel;

import ui.WoodCountFormListener;

@SuppressWarnings("serial")
public class Inventory extends DefaultListModel implements WoodCountFormListener {

	public void saveWoodCount(String essence) {
		addElement(essence);
	}

}
