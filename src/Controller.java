import java.awt.BorderLayout;

import javax.swing.JPanel;

import data.Inventory;
import ui.VisionFrame;
import ui.VisionToolBar;
import ui.VisionToolBarListener;

public class Controller implements VisionToolBarListener {

	private JPanel mainFrame;
	private VisionToolBar visionToolBar;
	private VisionFrame visionFrame;
	private Inventory inventory;
	
	public Controller() {
		inventory = new Inventory();
		getVisionToolBar().register(this);
		counterVisionAsked();
	}
	
	public VisionFrame getVisionFrame() {
		if (visionFrame == null) {
			visionFrame = new VisionFrame();
			
			visionFrame.getWoodCountFormFrame().getWoodCountForm().register(inventory);
			visionFrame.getWoodCountListFrame().getWoodCountList().setData(inventory);
		}
		return visionFrame;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	public VisionToolBar getVisionToolBar() {
		if (visionToolBar == null) {
			visionToolBar = new VisionToolBar();
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

	public void counterVisionAsked() {
		getVisionFrame().getWoodCountFormFrame().setVisible(true);
		
		getVisionFrame().getWoodCountListFrame().setVisible(true);
		getVisionFrame().getWoodCountListFrame().setLocation(
				getVisionFrame().getWoodCountFormFrame().getX()
				+ getVisionFrame().getWoodCountFormFrame().getWidth()
				+ 20,
				getVisionFrame().getWoodCountListFrame().getY());
	}

	public void marketVisionAsked() {
		getVisionFrame().getWoodCountFormFrame().setVisible(false);
		
		getVisionFrame().getWoodCountListFrame().setVisible(true);
		getVisionFrame().getWoodCountListFrame().setLocation(20, 
				getVisionFrame().getWoodCountListFrame().getY());
	}

}
