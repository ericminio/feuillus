package ui.request;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class WoodRequestListFrame extends JInternalFrame {

	private WoodRequestList woodRequestList;
	
	public WoodRequestListFrame() {
		setTitle("Demandes");
		addComponents();
	}
	
	protected void addComponents() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getWoodRequestList());
		pack();
	}

	public WoodRequestList getWoodRequestList() {
		if (woodRequestList == null) {
			woodRequestList = new WoodRequestList();
		}
		return woodRequestList;
	}
}
