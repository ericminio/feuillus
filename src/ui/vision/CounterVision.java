package ui.vision;

import ui.VisionFrame;

public class CounterVision implements Vision {

	public void activateVisionIn(VisionFrame visionFrame) {
		visionFrame.getWoodCountFormFrame().setVisible(true);
		
		visionFrame.getWoodCountListFrame().setVisible(true);
		visionFrame.getWoodCountListFrame().setLocation(
				visionFrame.getWoodCountFormFrame().getX()
				+ visionFrame.getWoodCountFormFrame().getWidth()
				+ 20,
				
				visionFrame.getWoodCountListFrame().getY());
		
		visionFrame.getWoodRequestListFrame().setVisible(false);
		visionFrame.getStatisticFrame().setVisible(false);
	}
}
