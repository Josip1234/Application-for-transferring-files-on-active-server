package transfer.files.to.server.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import transfer.files.to.server.db.ActiveServer;

/***
 * 
 * @author Josip Bošnjak
 * This contains destination server validation.
 * Files will not be copied or deleted until there is validated path of 
 * destination folder found in json file. This is security feature to 
 * prevent user accidently delete all files in folder which is 
 * not on server.
 *
 */
public class ProcessJson {
	
	
	
	/***
	 * 
	 * @return list of key values of the servers.
	 */
	public List<Map> returnListOfKeyValuesFromJson(){
		Map<String, String> servers=new HashMap<String, String>();
		List<Map> listOfServers = new ArrayList<Map>();
	

		return listOfServers;
	}
	

}
