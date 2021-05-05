package transfer.files.to.server.algorithms;

import java.io.File;

import org.apache.commons.io.FileUtils;

/***
 * 
 * @author Josip Bošnjak
 * This will delete transfer files from destination directory.
 *
 */
public class DeleteFiles {
	/***
	 * Delete files and folders at destinatination. Use file utils external library.
	 * @param destination from where files will be deleted.
	 */
	public static void deleteFilesFromServer(String destinationPath) {
	  FileUtils.deleteQuietly(new File(destinationPath));
	}

}
