package ui;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

@SuppressWarnings("serial")
public class WoodCountList extends JPanel {

	private JList woodCountList;
	
	public WoodCountList() {
		addComponents();
	}
	
	protected void addComponents() {
		add(getList());
	}
	
	public JList getList() {
		if (woodCountList == null) {
			woodCountList = new JList();
			woodCountList.setPreferredSize(new Dimension(200, 300));
		}
		return woodCountList;
	}

	public void setData(ListModel listModel) {
		getList().setModel(listModel);
	}
}
