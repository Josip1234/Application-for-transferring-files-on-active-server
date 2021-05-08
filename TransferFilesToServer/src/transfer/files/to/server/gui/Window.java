package transfer.files.to.server.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import transfer.files.to.server.algorithms.CopyFiles;
import transfer.files.to.server.algorithms.DeleteFiles;
import transfer.files.to.server.algorithms.ScanDirectory;

/***
 * 
 * @author Josip Bošnjak
 * 
 *
 */
public class Window {
    public static final Integer width=300;
    public static final Integer height=80;
    public static final String serverWord="\\bhtdocs\\b";
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
		frame.setMinimumSize(new Dimension(width, height));
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
	 * if files are successfull copied, return successfull message if not return unsuccessfull message.
	 */
	public static void createAnotherFrame(String folder) {
		String source=folder;
		//System.out.println(source);
		ScanDirectory directory = new ScanDirectory();
		List<String> filesInDirectory=directory.returnFilePathsFromSource(folder);
		//list file structure in new window as jtree
		JFrame frame2 = new JFrame("List of files and folders");
		DefaultMutableTreeNode list = new DefaultMutableTreeNode("list");
		for (String string : filesInDirectory) {
			DefaultMutableTreeNode list2 = new DefaultMutableTreeNode(string);
			list.add(list2);
		}
		JTree tree = new JTree(list);
		frame2.add(tree);
		frame2.add(new JScrollPane(tree), BorderLayout.CENTER);
		frame2.setSize(500, 500);
		frame2.setVisible(true);
		
		
		
		//
		//filesInDirectory.forEach(System.out::println);
		JButton button2 = Buttons.createAnotherButton();
		JFrame frame = new JFrame("Transfer files to server");
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		//JLabel label = new JLabel("New label");
		//label.setPreferredSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(button2,BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		//after destiunation is chosen, ask user if he really wants to copy those files.
	    button2.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					DialogBox box = new DialogBox();
					box.showDialogBox();
					frame.setVisible(false);
					String folder2=FolderChooser.chooseFolder(frame);
					//if there is htdocs copy files else dont
					Pattern pattern = Pattern.compile(serverWord);
					Matcher matcher = pattern.matcher(folder2);
					boolean found=false;
					while (matcher.find())
					{
					    System.out.print("Start index: " + matcher.start());
					    System.out.print(" End index: " + matcher.end() + " ");
					    System.out.println(matcher.group());
					    found=true;
					}
					
					
					if(found==true) {
					String destination=folder2;
					CopyFiles copyFiles = new CopyFiles();
					try {
						boolean isItCopied=false;
						isItCopied=copyFiles.copyFiles(source, destination);
						if(isItCopied==true) {
							JOptionPane.showMessageDialog(frame, "Files successfully copied.");
							DeleteFiles files = new DeleteFiles();
							//files.deleteFilesFromServer(destination);
							System.exit(0);
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						JOptionPane.showMessageDialog(frame,"Not server folder!" ,"Error",JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					
				}});
	    }
	    
	}
	
	

	    
