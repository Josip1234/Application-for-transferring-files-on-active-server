package transfer.files.to.server.algorithms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * 
 * @author Josip Bošnjak
 * This class contains algorithm which will scan all the files in the directory path. 
 * It will return list of files, not file names, already file paths with file name and extensions.
 *
 */
public class ScanDirectory {
	/***
	 * Here, we've populated a Stream using the .walk() method, passing a Paths argument. The Paths class consists of static methods that return a Path based on a String URI - and using a Path, we can locate the file easily.
       The Path, Paths, Files, and many other classes belong to the java.nio package, which was introduced in Java 7 as a more modern way to represent files in a non-blocking way.
	 * @param directoryToScan
	 * @return list of files in directory
	 */
	public List<String> returnFilePathsFromSource(String directoryToScan) {
		List<String> files = new ArrayList<String>();
		try {
			Stream<Path> path = Files.walk(Paths.get(directoryToScan));
			List<String> result = path.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());
			files=result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return files;
		
	}

}
