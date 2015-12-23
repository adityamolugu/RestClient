import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.microsoft.azure.storage.file.FileInputStream;

@SuppressWarnings("deprecation")
public class RestClient {

 public static void main(String[] args) throws ClientProtocolException, IOException 
 {

	 String userName = "amolugu";
	 String password = "ecm";
  @SuppressWarnings("resource")
  HttpClient client = new DefaultHttpClient();

  HttpPost request =  new HttpPost("https://ecm-service.psft.co/ecms/documents"); //new HttpGet('http://restUrl');
  String authString = userName + ":" + password;
  byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
  String authStringEnc = new String(authEncBytes);

  
  request.addHeader("Authorization", "Basic "+authStringEnc);
  request.addHeader("Accept", "application/json");
  request.addHeader("saTenant", "india");
  request.addHeader("saLicense", "1");
  request.addHeader("Content-Type", "Multipart/Related; boundary=2676ff6efebdb664f8f7ccb34f864e25");
  //http://32872a3343874da6a818792a8e3a8399.cloudapp.net/InnovationProject/rest/patients/ID310/blooddoc/210
  
  String body = "";
  String fileContents = "";
  File file = new File ("C:\\Users\\Aditya.Molugu\\workspace\\RestClient\\src\\body.txt");
  
  //java.io.FileInputStream fis = new java.io.FileInputStream(file);
  
  BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Aditya.Molugu\\workspace\\RestClient\\src\\body.txt"));

  while ((fileContents = br.readLine()) != null) {
		body = body + fileContents;
	}
  
  
 // request.setEntity(new );
  //String body = fis.;
  
  HttpEntity entity ;
  
  
  
 
  HttpResponse response = client.execute(request);

  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));

  String line = "";

  while ((line = rd.readLine()) != null) 
  {
    System.out.println(line);
  }

 }

}

//new HttpGet("http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/");//
//"http://172.26.32.49:8080/InnovationProject/rest/patients/ID310/blooddoc/199"