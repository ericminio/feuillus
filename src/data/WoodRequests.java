package data;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class WoodRequests extends DefaultListModel {

	public WoodRequests() {
		setData();
	}
	
	public void setData() {
		final String[] data = {"200m3 chene", "100m3 hetre", "100m3 chene", "140m3 hetre", "300m3 cerisier"};
		for (String request : data) {
			addElement(request);
		}
	}
}
