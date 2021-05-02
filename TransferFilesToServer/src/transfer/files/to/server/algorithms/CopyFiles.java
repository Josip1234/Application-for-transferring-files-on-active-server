package transfer.files.to.server.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;



/***
 * 
 * @author Josip Bošnjak
 * This class provides algorithms for file copy.
 *
 */
public class CopyFiles {
	/***
	 * Return true if file copy is successfull, Return false if it is not.
	 * @param source
	 * @param destination
	 * @return true if file copy was successfull
	 * @throws IOException 
	 */
	public boolean copyFiles(String source, String destination) throws IOException {
		boolean successfull=false;
		File sourceFile = new File(source.replace('\\', '/'));
		File destinationFile=new File(destination.replace('\\', '/'));
		FileUtils.copyDirectory(sourceFile, destinationFile);
		return successfull;
	}

}
