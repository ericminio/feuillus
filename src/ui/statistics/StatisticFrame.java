package ui.statistics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.ListModel;

@SuppressWarnings("serial")
public class StatisticFrame extends JInternalFrame {

	private JList statisticList;
	
	public StatisticFrame() {
		setTitle("Statistiques");
		addComponents();
	}
	
	protected void addComponents() {
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(getStatisticList());
		pack();
	}

	public JList getStatisticList() {
		if (statisticList == null) {
			statisticList = new JList();
			statisticList.setPreferredSize(new Dimension(150, 200));
			statisticList.setEnabled(false);
		}
		return statisticList;
	}

	public void setStatistics(ListModel model) {
		getStatisticList().setModel(model);
	}
}
