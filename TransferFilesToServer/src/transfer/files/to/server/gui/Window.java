package transfer.files.to.server.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/***
 * 
 * @author Josip Bošnjak
 * 
 *
 */
public class Window {
    public static final Integer width=800;
    public static final Integer height=600;
    /****
     * Add window with default 800x600 dimesion, with default close operation.
     * Default minimum size of frame window is 500x500, maximum 800x600.
     * Flow layout is added to prevent big button to show on jframe.
     * Frame will not be possible to maximize.
     *  Activate new window after button is clicked.
     * Add button from buttons class to the jframe.
     * Close first frame after second is opened.
     */
	public static void createFrame() {
		JButton button = Buttons.createButton();
		JFrame frame = new JFrame("Transfer files to server");
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(500, 500));
		//JLabel label = new JLabel("New label");
		//label.setPreferredSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(button,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
	    button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				createAnotherFrame();
				
				
			}});
	}
	/***
	 * Create another frame after first button is clicked.
	 */
	public static void createAnotherFrame() {
		JButton button = Buttons.createAnotherButton();
		JFrame frame = new JFrame("Transfer files to server");
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(500, 500));
		//JLabel label = new JLabel("New label");
		//label.setPreferredSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(button,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
	    
