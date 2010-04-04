package ui.request;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

@SuppressWarnings("serial")
public class WoodRequestList extends JPanel {

	private JList woodRequestList;
	
	public WoodRequestList() {
		addComponents();
	}
	
	protected void addComponents() {
		add(getList());
	}
	
	public JList getList() {
		if (woodRequestList == null) {
			woodRequestList = new JList();
			woodRequestList.setPreferredSize(new Dimension(200, 300));
		}
		return woodRequestList;
	}
	
	public void setData(ListModel listModel) {
		getList().setModel(listModel);
	}
	
}
