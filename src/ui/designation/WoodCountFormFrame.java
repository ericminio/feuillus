package ui.designation;
import java.awt.BorderLayout;

import javax.swing.JInternalFrame;


@SuppressWarnings("serial")
public class WoodCountFormFrame extends JInternalFrame {

	private WoodCountForm woodCountForm;
	
	public WoodCountFormFrame() {
		addComponents();
	}
	
	protected void addComponents() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getWoodCountForm());
		pack();
	}
	
	public WoodCountForm getWoodCountForm() {
		if (woodCountForm == null) {
			woodCountForm = new WoodCountForm();
		}
		return woodCountForm;
	}
}
