package ui;
import java.awt.Dimension;

import javax.swing.JDesktopPane;


@SuppressWarnings("serial")
public class VisionFrame extends JDesktopPane {

	private WoodCountFormFrame formFrame;
	private WoodCountListFrame listFrame;
	
	public VisionFrame() {
		setSize(new Dimension(700, 500));
		addFrames();
	}
	
	protected void addFrames() {
		add(getWoodCountFormFrame());
		add(getWoodCountListFrame());
	}
	
	public WoodCountFormFrame getWoodCountFormFrame() {
		if (formFrame == null) {
			formFrame = new WoodCountFormFrame();
			formFrame.setVisible(true);
		}
		return formFrame;
	}

	public WoodCountListFrame getWoodCountListFrame() {
		if (listFrame == null) {
			listFrame = new WoodCountListFrame();
			listFrame.setVisible(true);
		}
		return listFrame;
	}

	
}
