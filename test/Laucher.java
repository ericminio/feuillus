import java.awt.Container;

import javax.swing.JFrame;

public class Laucher {

	public static void main(String... argv) {
		Controller controller = new Controller();
		show(controller.getMainFrame());
	}

	private static void show(Container contentPane) {
		JFrame frame = new JFrame();
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
}
