import java.awt.BorderLayout;

import javax.swing.JPanel;

import ui.VisionFrame;
import ui.VisionToolBar;
import ui.VisionToolBarListener;
import ui.vision.CounterVision;
import ui.vision.Vision;
import data.Inventory;

public class Controller implements VisionToolBarListener {

	private Inventory inventory;
	private JPanel mainFrame;
	private VisionToolBar visionToolBar;
	private VisionFrame visionFrame;
	
	public Controller() {
		activateVision(new CounterVision());
	}
	
	public VisionFrame getVisionFrame() {
		if (visionFrame == null) {
			visionFrame = new VisionFrame();
			
			visionFrame.getWoodCountFormFrame().getWoodCountForm().register(getInventory());
			visionFrame.getWoodCountListFrame().getWoodCountList().setData(getInventory());
		}
		return visionFrame;
	}

	public VisionToolBar getVisionToolBar() {
		if (visionToolBar == null) {
			visionToolBar = new VisionToolBar();
			visionToolBar.register(this);
		}
		return visionToolBar;
	}

	public JPanel getMainFrame() {
		if (mainFrame == null) {
			mainFrame = new JPanel();
			mainFrame.setLayout(new BorderLayout());
			mainFrame.add(getVisionFrame(), BorderLayout.CENTER);
			mainFrame.add(getVisionToolBar(), BorderLayout.NORTH);
		}
		return mainFrame;
	}

	public Inventory getInventory() {
		if (inventory == null) {
			inventory = new Inventory();
		}
		return inventory;
	}

	public void activateVision(Vision vision) {
		vision.activateVisionIn(getVisionFrame());
	}

}
