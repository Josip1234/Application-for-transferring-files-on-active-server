package transfer.files.to.server.gui;

import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.*;


/**
 * 
 * @author Josip Bošnjak
 * Class for opening dialog box for message confirm if user is sure 
 * he wants to copy files to destination folder.
 *
 */
public class DialogBox{
	JFrame frame;
	/***
	 * Activate dialog box trough constructor
	 */
	public boolean showDialogBox() {
		frame=new JFrame();
		frame.setSize(200, 200);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int a = JOptionPane.showConfirmDialog(frame, "Are you sure do you want to copy those files?");
		if(a==JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else {
			System.exit(0);
		}
		frame.setVisible(true);
		return true;
	}

}
