package ui.designation;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

@SuppressWarnings("serial")
public class WoodCountList extends JPanel {

	private JList woodCountList;
	private JScrollPane scrollPane;
	
	public WoodCountList() {
		addComponents();
	}
	
	protected void addComponents() {
		add(getScrollPane());
	}
	
	public JList getList() {
		if (woodCountList == null) {
			woodCountList = new JList();
		}
		return woodCountList;
	}

	public void setData(ListModel listModel) {
		getList().setModel(listModel);
	}
	
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(getList());
			scrollPane.setPreferredSize(new Dimension(180, 300));
		}
		return scrollPane;
	}
}
