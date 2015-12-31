/**
 * 
 */
package dataobject;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @author Aditya.Molugu
 *
 */
public class SetRequest {
	
	public static void main(String[] args)
	{
		setECMRequest();
	}
	
	public static String setECMRequest()
	{
		Request request = new Request();
		ArchiveReference archiveReference = new ArchiveReference();
		archiveReference.setName("DDC_india01");
		request.setArchiveReference(archiveReference);
		
		//Index index = new Index();
		Properties properties = new Properties();
		properties.setPropertyValue("MyString");
		properties.setType("STRING");
		
		Properties propertiesInt = new Properties();
		propertiesInt.setType("INTEGER");
		propertiesInt.setPropertyValue(new Integer(42));
		
		Map map = new HashMap<String,Object>();
		map.put("STRING_100", properties);
		map.put("INTEGERFIELD", propertiesInt);
		//index.setIndex(map);
		//index.setIndexName("STRING_100");
		//index.setProperties(properties);
		request.setIndex(map);
		
		Structure structure = new Structure();
		structure.setElement_type("structure");
		Children[] children = new Children[1];
		children[0] = new Children();
		Content content = new Content();
		content.setType("multipart_reference");
		content.setUri("cid:imagefile");
		
		children[0].setElement_type("file");
		children[0].setFileName("base64.png");
		children[0].setContent(content);
		
		structure.setChildren(children);
		request.setStructure(structure);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(request);
		
		System.err.println("JsonString is: "+jsonString);
		
		return jsonString;
	}

}
