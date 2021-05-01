package transfer.files.to.server.gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.stage.FileChooser;

/***
 * 
 * @author Josip Bošnjak
 *
 */
public class FolderChooser {
 
	/***
	 * Choose folder, return folder path.
	 *
	 * @return folder path as string.
	 */
	public static String chooseFolder(JFrame frame) {
		String folder="";
		JFileChooser choser= new JFileChooser();
		choser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option= choser.showOpenDialog(frame);
		if(option==JFileChooser.APPROVE_OPTION) {
			File file = choser.getSelectedFile();
			folder=file.getPath();
		}else {
			System.out.println();
		}
		return folder;
	}
}
