import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.microsoft.azure.storage.file.FileInputStream;

@SuppressWarnings("deprecation")
public class GetFileFromSaperionECM {

 public static void main(String[] args) throws ClientProtocolException, IOException 
 {

	 String userName = "amolugu";
	 String password = "ecm";
  @SuppressWarnings("resource")
  HttpClient client = new DefaultHttpClient();

  HttpGet request =  new HttpGet("https://ecm-service.psft.co/ecms/documents/ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIkZENTVDMEZFQUY4Q0NGNDI4MjhFODIzRjhCMzhBQTlCMDAwMDAwMDAwMDAwIg0KfQ%3D%3D"); //new HttpGet('http://restUrl');
  //https://ecm-service.psft.co/ecms/documents/ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIkZENTVDMEZFQUY4Q0NGNDI4MjhFODIzRjhCMzhBQTlCMDAwMDAwMDAwMDAwIg0KfQ%3D%3D
  //https://ecm-service.psft.co/ecms/documents/ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIkMxREZBREY1NzUxMEYwNDQ4OTVBMzg0Nzg1RjA1NEYwMDAwMDAwMDAwMDAwIg0KfQ%253D%253D
  String authString = userName + ":" + password;
  byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
  String authStringEnc = new String(authEncBytes);

  
  request.addHeader("Authorization", "Basic "+authStringEnc);
  request.addHeader("Accept", "multipart/related");
  request.addHeader("saTenant", "india");
  request.addHeader("saLicense", "1");
  //request.addHeader("Content-Type", "Multipart/Related; boundary=2676ff6efebdb664f8f7ccb34f864e25");
  //http://32872a3343874da6a818792a8e3a8399.cloudapp.net/InnovationProject/rest/patients/ID310/blooddoc/210
  
 /* String body = "";
  String fileContents = "";
  File file = new File ("C:\\Users\\Aditya.Molugu\\workspace\\RestClient\\src\\body.txt");*/
  
  //java.io.FileInputStream fis = new java.io.FileInputStream(file);
  
 /* BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Aditya.Molugu\\workspace\\RestClient\\src\\body.txt"));

  while ((fileContents = br.readLine()) != null) {
		body = body + fileContents;
	}
  */
  
 // request.setEntity(new );
  //String body = fis.;
  
  //HttpEntity entity ;
  
  
  
 
  HttpResponse response = client.execute(request);
  
 // HttpEntity entity = response.getEntity();
  //System.out.println("printing one: "+EntityUtils.getContentMimeType(entity));
  //System.out.println("printing two: "+EntityUtils.getContentCharSet(entity));
  
  /*HttpEntity responseEntity = response.getEntity();
  if(responseEntity!=null) {
     String str = EntityUtils.toString(responseEntity);
     System.err.println("str is::::"+str);
  }*/
  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));//getEntity().getContent()
  //IOUtils.;
  
  //Bitmap bitmap = BitmapFactory.decodeStream((InputStream) response.getEntity().getContent());
  StringBuilder content = new StringBuilder();
  String line;
  while (null != (line = rd.readLine()))
  {
      content.append(line);
  }
  
  //System.err.println(content.toString());
  
 // HttpParams entities = response.getParams();
 // System.out.println("entities are "+entities.getParameter("--be2c4d7c-23ed-4c80-bd64-e8397ebcf30d"));
  //entities.getContentType().
  
  //MultipartEntityBuilder multipart = (MultipartEntityBuilder) response.getEntity();
  
  
  /*
  Header[] message = response.getAllHeaders();
  
  for(Header header: message)
  {
	  System.err.print(header.getName()+" ");
  	  System.err.println(header.getValue());
  }*/
  
//  response.getParams();
  
  
  
  //response.
  String boundaryValue = "";
  BufferedReader rd1 = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));//getEntity().getContent()
  Header[] header = response.getAllHeaders();
  
  for(Header head : header)
  {
	  String headerValue = head.getValue().toString();
	  System.err.println("header value is: "+headerValue);
	  
	  if(headerValue.contains("boundary="))
	  {
		  String[] str = headerValue.split("boundary=");
		  boundaryValue = "--"+str[1];
		  //System.err.println(str[1]);
		  break;
	  }
  }
  
  String[] strArray = content.toString().split(boundaryValue);
  
  for(String str : strArray)
  {
	  //System.err.println("value of each string is: "+str);
	  if(str.contains("application/octet-stream"))
	  {
		  String[] str2 = str.split("application/octet-stream");
		  String str3 = str2[1];
		  System.err.println("file value is: "+str3);
		  break;
	  }
  }
  
 /* String line = "";

  while ((line = rd.readLine()) != null) 
  {
    System.out.println(line);
  }*/

 }

}

//new HttpGet("http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/");//
//"http://172.26.32.49:8080/InnovationProject/rest/patients/ID310/blooddoc/199"