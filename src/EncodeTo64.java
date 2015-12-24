import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 */

/**
 * @author Aditya.Molugu
 *
 */
public class EncodeTo64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Method used for encode <span id="IL_AD2" class="IL_AD">the file</span> to base64 binary format
		 * @param file
		 * @return encoded file format
		 */
		
		String str = encodeFileToBase64Binary(new File("Binaries.txt"));
		System.err.println("String is: "+str);

	}
	
	private static String encodeFileToBase64Binary(File file)
	{
	    String encodedfile = null;
	    try {
	        FileInputStream fileInputStreamReader = new FileInputStream(file);
	        byte[] bytes = new byte[(int)file.length()];
	        fileInputStreamReader.read(bytes);
	        encodedfile = Base64.encodeBase64(bytes).toString();
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	     
	    return encodedfile;
	}

}
