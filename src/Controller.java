import java.awt.BorderLayout;

import javax.swing.JPanel;

import ui.VisionFrame;
import ui.VisionToolBar;
import ui.VisionToolBarListener;
import ui.vision.MarketVision;
import ui.vision.Vision;
import data.AvailableWoods;
import data.MarketController;
import data.WoodRequests;

public class Controller implements VisionToolBarListener {

	private JPanel mainFrame;
	private VisionToolBar visionToolBar;
	private VisionFrame visionFrame;
	
	private AvailableWoods availableWoods;
	private WoodRequests woodRequests;
	private MarketController marketController;
	
	public Controller() {
		activateVision(new MarketVision());
	}
	
	public VisionFrame getVisionFrame() {
		if (visionFrame == null) {
			visionFrame = new VisionFrame();
			
			visionFrame.getWoodCountFormFrame().getWoodCountForm().register(getAvailableWoods());
			visionFrame.getWoodCountListFrame().getWoodCountList().setData(getAvailableWoods());
			visionFrame.getWoodCountListFrame().getWoodCountList().getList().addListSelectionListener(getMarketController());
			visionFrame.getWoodRequestListFrame().getWoodRequestList().setData(getWoodRequests());
			visionFrame.getWoodRequestListFrame().getWoodRequestList().getList().addListSelectionListener(getMarketController());
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

	public AvailableWoods getAvailableWoods() {
		if (availableWoods == null) {
			availableWoods = new AvailableWoods();
		}
		return availableWoods;
	}

	public void activateVision(Vision vision) {
		vision.activateVisionIn(getVisionFrame());
	}

	public WoodRequests getWoodRequests() {
		if (woodRequests == null) {
			woodRequests = new WoodRequests();
		}
		return woodRequests;
	}

	public MarketController getMarketController() {
		if (marketController == null) {
			marketController = new MarketController();
			marketController.setAvailableWoods(getAvailableWoods());
			marketController.setWoodRequests(getWoodRequests());
		}
		return marketController;
	}

}
