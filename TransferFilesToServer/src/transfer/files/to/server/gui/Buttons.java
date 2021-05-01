package transfer.files.to.server.gui;
/**
 * 
 * @author Josip Bošnjak
 * 
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Buttons {
	
	public static final Integer width=200;
	public static final Integer height=200;
	public static final boolean visible=true;
	/***
	 * Create new jbutton with default 200x200 dimensions, and visible on jframe.
	 * @return created jbutton
	 */
	public static JButton createButton() {
		JButton button = new JButton();
		button.setSize(width,height);
		button.setVisible(visible);
		button.setText("Find source server:");
		
		return button;
	}
	
}
