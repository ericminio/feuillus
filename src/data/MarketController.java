package data;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MarketController implements ListSelectionListener {

	private AvailableWoods woods;
	private WoodRequests requests;
	
	private int selectedWoodIndex;
	private int selectedRequestIndex;
	
	private Statistics statistics;
	
	public MarketController() {
		selectedWoodIndex = -1;
		selectedRequestIndex = -1;
	}
	
	public void setAvailableWoods(AvailableWoods woods) {
		this.woods = woods;
	}

	public AvailableWoods getAvailableWoods() {
		return woods;
	}

	public void setWoodRequests(WoodRequests requests) {
		this.requests = requests;
	}

	public WoodRequests getWoodRequests() {
		return requests;
	}

	public void valueChanged(ListSelectionEvent e) {
		ListModel model = ((JList) e.getSource()).getModel();
		int index = ((JList) e.getSource()).getSelectedIndex();
		if (!e.getValueIsAdjusting()) {
			if (model == woods) {
				setAvailableWoodSelected(index);
			}
			else {
				setWoodRequestSelected(index);
			}
		}
	}

	protected void setAvailableWoodSelected(int index) {
		selectedWoodIndex = index;
		removeIfMatch();
	}

	protected void setWoodRequestSelected(int index) {
		selectedRequestIndex = index;
		removeIfMatch();
	}

	protected void removeIfMatch() {
		if (selectedWoodIndex == -1) return;
		if (selectedRequestIndex == -1) return;
		
		String selectedWood = (String) woods.get(selectedWoodIndex);
		String selectedRequest = (String) requests.get(selectedRequestIndex);
		if (match(selectedWood, selectedRequest)) {
			signContract();
		}
	}

	protected boolean match(String selectedWood, String selectedRequest) {
		return selectedWood.equalsIgnoreCase(selectedRequest);
	}

	protected void signContract() {
		woods.remove(selectedWoodIndex);
		String removed = (String) requests.remove(selectedRequestIndex);
		if (statistics != null) {
			updateStats(removed);
		}
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public Statistics getStatistics() {
		return statistics;
	}
	
	protected void updateStats(String removed) {
		statistics.addContract(removed);
	}
}
