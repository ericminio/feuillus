package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import ui.vision.CounterVision;
import ui.vision.MarketVision;

@SuppressWarnings("serial")
public class VisionToolBar extends JToolBar {

	private JButton counterButton;
	private JButton commercialButton;
	private VisionToolBarListener listener;
	
	public VisionToolBar() {
		setFloatable(false);
		setLayout(new FlowLayout());
		addButtons();
	}
	
	protected void addButtons() {
		add(getCounterButton());
		add(getCommercialButton());
	}
	
	public JButton getCounterButton() {
		if (counterButton == null) {
			counterButton = new JButton();
			counterButton.setText("Designation");
			counterButton.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					counterButtonClicked();
				}
			});
		}
		return counterButton;
	}
	
	public JButton getCommercialButton() {
		if (commercialButton == null) {
			commercialButton = new JButton();
			commercialButton.setText("Vente");
			commercialButton.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					marketButtonClicked();
				}
			});
		}
		return commercialButton;
	}

	public void register(VisionToolBarListener listener) {
		this.listener = listener;
	}

	public VisionToolBarListener getListener() {
		return listener;
	}

	public void counterButtonClicked() {
		if (listener != null) {
			listener.activateVision(new CounterVision());
		}
	}

	public void marketButtonClicked() {
		if (listener != null) {
			listener.activateVision(new MarketVision());
		}
	}
}
