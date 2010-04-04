package ui.vision;

import ui.VisionFrame;

public class MarketVision implements Vision {

	public void activateVisionIn(VisionFrame visionFrame) {
		visionFrame.getWoodCountFormFrame().setVisible(false);
		
		visionFrame.getWoodCountListFrame().setVisible(true);
		visionFrame.getWoodCountListFrame().setLocation(20, 
				visionFrame.getWoodCountListFrame().getY());
	}
}