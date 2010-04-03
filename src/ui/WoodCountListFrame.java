package ui;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class WoodCountListFrame extends JInternalFrame {

	private WoodCountList woodCountList;
	
	public WoodCountListFrame() {
		addComponents();
	}
	
	protected void addComponents() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getWoodCountList());
		pack();
	}

	public WoodCountList getWoodCountList() {
		if (woodCountList == null) {
			woodCountList = new WoodCountList();
		}
		return woodCountList;
	}
}
