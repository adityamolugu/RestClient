import java.io.FileReader;
import java.util.Iterator;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 */

/**
 * @author Aditya.Molugu
 *
 */
public class Trial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Random rand = new Random();
		int myRandomNumber = rand.nextInt(0x10) + 0x10 + 0x10 + 0x10 + 0x10; // Generates a random number between 0x10 and 0x20
		System.out.printf("%x\n",myRandomNumber); // Prints it in hex, such as "0x14"
		// or....
		String result = Integer.toHexString(myRandomNumber);
		System.err.println(result);*/
		
		String hexCode = getHexCode();
		
		/*JsonElement jelement = new JsonParser().parse(responseData); 
	    JsonObject  jobject = jelement.getAsJsonObject(); 
	    String result = jobject.get("token").toString(); 
	    System.err.println("result:"+result);*/
	    
	    JsonParser parser = new JsonParser();
	    
        try {
 
            Object obj = parser.parse(new FileReader(
                    "C:\\Users\\Aditya.Molugu\\Desktop\\JSON_TEXT.txt"));
 
            JsonObject jsonObject = (JsonObject) obj;
 
            String name =  jsonObject.get("name").toString();
            //String author =  jsonObject.get("propertyValue").toString();
           // JsonArray companyList = (JsonArray) jsonObject.get("Company List");
 
            System.out.println("Name: " + name);
           // System.out.println("Author: " + author);
            //System.out.println("\nCompany List:");
            /*Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/
        }
        catch(Exception ex)
        {
        	ex.getMessage();
        }
		
	}

	/**
	 * 
	 */
	private static String getHexCode() 
	{
		long numb = (long)(Math.random() * 100000000 * 1000000); // had to use this as int's are to small for a 13 digit number.
       
		String result = Long.toHexString(numb);
		System.err.println(result);
		return result;
	}
	
	
	
	

	

}
