import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Laucher {

	public static void main(String... argv) {
		Controller controller = new Controller();
		show(controller.getMainFrame());
	}

	private static void show(Container contentPane) {
		JFrame frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		
		frame.getContentPane().add(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
}
