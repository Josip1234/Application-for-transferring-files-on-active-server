package transfer.files.to.server.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {
    public static final Integer width=800;
    public static final Integer height=600;
	public static void createFrame() {
		JFrame frame = new JFrame("Transfer files to server");
		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(label,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	
}
}
