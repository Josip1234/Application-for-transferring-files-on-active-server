package transfer.files.to.server.algorithms;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import org.apache.commons.io.FileUtils;



/***
 * 
 * @author Josip Bošnjak
 * This class provides algorithms for file copy.
 *
 */
public class CopyFiles {
	public JProgressBar bar;
	   long totalSize = 0; //total size of directories/files
	    long currentSize = 0;   //current size of files counting up to ONE_PERCENT
	    int currentPercent = 0; //current progress in %
	    long ONE_PERCENT;       //totalSize / 100
	
	/***
	 * Return true if file copy is successfull, Return false if it is not.
	 * @param source
	 * @param destination
	 * @return true if file copy was successfull
	 * @throws IOException 
	 */
	public boolean copyFiles(String source, String destination,JFrame frame) throws IOException {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		boolean successfull=false;
		File sourceFile = new File(source.replace('\\', '/'));
		File destinationFile=new File(destination.replace('\\', '/'));
		bar = new JProgressBar(0, sourceFile.list().length);
		bar.setValue(0);
		bar.setStringPainted(true);
		bar.setVisible(true);
		frame.add(bar);
		frame.setVisible(true);
		for (int i = 0; i < sourceFile.list().length; i++){
		    for(File file: sourceFile.listFiles()){
		        try{
		            FileUtils.copyDirectory(sourceFile, destinationFile);
		           
		            
		            if(sourceFile.list().length >= ONE_PERCENT){
                        currentPercent++;
                        bar.setValue(currentPercent);
                        bar.setVisible(true);
                        currentSize = 0;
                    } else {
                        currentSize = currentSize + sourceFile.list().length;
                        if(currentSize >= ONE_PERCENT){
                            currentPercent++;
                            bar.setValue(currentPercent);
                            bar.setVisible(true);
                            currentSize = 0;
                        }
                    }
		            
		            
		        } catch (IOException e){
		            e.printStackTrace();
		        }
		    }
		}
		
		
		//FileUtils.copyDirectory(sourceFile, destinationFile);
		successfull=true;
		return successfull;
	}

}
