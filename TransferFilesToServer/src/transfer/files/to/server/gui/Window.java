package transfer.files.to.server.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import transfer.files.to.server.algorithms.ScanDirectory;

/***
 * 
 * @author Josip Bo�njak
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
     *  Choose folder where server is located.
     * Close frame.  
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
				String folder=FolderChooser.chooseFolder(frame);
				createAnotherFrame(folder);
				
				
			}});
	}
	/***
	 * @param folder - receive folder path
	 * Create another frame after first button is clicked.
	 * Choose project folder.
	 * After source folder is chosen, scan directory to obtain list of files to copy to active server.
	 * 
	 */
	public static void createAnotherFrame(String folder) {
		ScanDirectory directory = new ScanDirectory();
		List<String> filesInDirectory=directory.returnFilePathsFromSource(folder);
		//filesInDirectory.forEach(System.out::println);
		JButton button2 = Buttons.createAnotherButton();
		JFrame frame = new JFrame("Transfer files to server");
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(500, 500));
		//JLabel label = new JLabel("New label");
		//label.setPreferredSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(button2,BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		
	    button2.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					String folder2=FolderChooser.chooseFolder(frame);
					System.out.println(folder2);
					
					
				}});
	}
}
	    
