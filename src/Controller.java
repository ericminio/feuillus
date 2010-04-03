import data.Inventory;
import ui.MainFrame;


public class Controller {

	private MainFrame mainFrame;
	private Inventory inventory;
	
	public Controller() {
		inventory = new Inventory();
	}
	
	public MainFrame getMainFrame() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
			
			mainFrame.getWoodCountFormFrame().getWoodCountForm().register(inventory);
			mainFrame.getWoodCountListFrame().getWoodCountList().setData(inventory);
		}
		return mainFrame;
	}

	public Inventory getInventory() {
		return inventory;
	}

}
