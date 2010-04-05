import java.awt.BorderLayout;

import javax.swing.JPanel;

import ui.VisionFrame;
import ui.VisionToolBar;
import ui.VisionToolBarListener;
import ui.vision.MarketVision;
import ui.vision.Vision;
import data.AvailableWoods;
import data.MarketController;
import data.RequestRandomizer;
import data.Statistics;
import data.WoodRequests;

public class Controller implements VisionToolBarListener {

	private JPanel mainFrame;
	private VisionToolBar visionToolBar;
	private VisionFrame visionFrame;
	
	private AvailableWoods availableWoods;
	private WoodRequests woodRequests;
	private MarketController marketController;
	private RequestRandomizer requestRandomizer;
	
	private Statistics statistics;
	
	public Controller() {
		activateVision(new MarketVision());
		getRequestRandomizer().start();
	}
	
	public VisionFrame getVisionFrame() {
		if (visionFrame == null) {
			visionFrame = new VisionFrame();
			
			visionFrame.getWoodCountFormFrame().getWoodCountForm().register(getAvailableWoods());
			visionFrame.getWoodCountListFrame().getWoodCountList().setData(getAvailableWoods());
			visionFrame.getWoodCountListFrame().getWoodCountList().getList().addListSelectionListener(getMarketController());
			visionFrame.getWoodRequestListFrame().getWoodRequestList().setData(getWoodRequests());
			visionFrame.getWoodRequestListFrame().getWoodRequestList().getList().addListSelectionListener(getMarketController());
			visionFrame.getStatisticFrame().setStatistics(getStatistics());
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
			marketController.setStatistics(getStatistics());
		}
		return marketController;
	}

	public RequestRandomizer getRequestRandomizer() {
		if (requestRandomizer == null) {
			requestRandomizer = new RequestRandomizer();
			requestRandomizer.setWoodRequests(getWoodRequests());
		}
		return requestRandomizer;
	}

	public Statistics getStatistics() {
		if (statistics == null) {
			statistics = new Statistics();
		}
		return statistics;
	}

}
