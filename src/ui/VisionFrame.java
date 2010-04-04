package ui;
import java.awt.Dimension;

import javax.swing.JDesktopPane;

import ui.designation.WoodCountFormFrame;
import ui.designation.WoodCountListFrame;
import ui.request.WoodRequestListFrame;


@SuppressWarnings("serial")
public class VisionFrame extends JDesktopPane {

	private WoodCountFormFrame formFrame;
	private WoodCountListFrame listFrame;
	private WoodRequestListFrame requestFrame;
	
	public VisionFrame() {
		setSize(new Dimension(700, 500));
		addFrames();
	}
	
	protected void addFrames() {
		add(getWoodCountFormFrame());
		add(getWoodCountListFrame());
		add(getWoodRequestListFrame());
	}
	
	public WoodCountFormFrame getWoodCountFormFrame() {
		if (formFrame == null) {
			formFrame = new WoodCountFormFrame();
		}
		return formFrame;
	}

	public WoodCountListFrame getWoodCountListFrame() {
		if (listFrame == null) {
			listFrame = new WoodCountListFrame();
		}
		return listFrame;
	}
	
	public WoodRequestListFrame getWoodRequestListFrame() {
		if (requestFrame == null) {
			requestFrame = new WoodRequestListFrame();
		}
		return requestFrame;
	}

	
}
