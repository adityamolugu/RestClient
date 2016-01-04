package com.lexmark.saperion.util;
/*//package com.kofax.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.codehaus.jettison.json.JSONArray;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.json.impl.provider.entity.JSONArrayProvider;

public class PWClient {
	
	final private static String userName = "sreekanth.tadakamalla@lexmark.com";
	final private static String password = "Lexmark@123";
	
	public static void main(String [] args)
	{
		uploadFile();
	}
	
	public static void uploadFile(){
		getBasicToken();
	}
	
	public static void getBasicToken()
	{
		try {

			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new postRequest with below mentioned URL
			HttpGet getRequest = new HttpGet("https://pw-eu-qa.psft.co/fns-service/api/1/token/basic");


			// Add additional header to getRequest which accepts application/xml
			// data
			String authString = userName + ":" + password;
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			
			
			getRequest.addHeader("Authorization", "Basic "+authStringEnc);
			getRequest.addHeader("Accept", "application/json");


			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);

			// Check for HTTP response code: 200 = success
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			// Get-Capture Complete application/xml body response
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String responseData = "";
			String output = "";
			//System.out.println("============Output:============");

			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				responseData = responseData + "" +output;
			}
			
			System.out.println(responseData);
			
		  JSONArray jsonArray = new JSONArray(responseData);
		 
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println(jsonObject);
            }  
			Gson gson = new Gson();
			String str =  gson.toJson(responseData);
			
			System.err.println(str);
			
			JsonElement jelement = new JsonParser().parse(responseData);
		    JsonObject  jobject = jelement.getAsJsonObject();
		    String result = jobject.get("token").toString();
		    System.err.println("result:"+result);
		    //JsonArray jarray = jobject.getAsJsonArray("translations");
		    //jobject = jarray.get(0).getAsJsonObject();
		     //jobject.get("translatedText").toString();
			
			//gson.fromJson(str, "token");
			

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/