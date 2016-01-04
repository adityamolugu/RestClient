package com.lexmark.saperion.services;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/*
 * This Class is responsible for getting the file from Saperion ECM
 * 
 * */
@SuppressWarnings("deprecation")
public class GetFileFromSaperionECM {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String objectId = "ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIjcyOUE2QUFCNzlEODEyNDM4NEQyRTM1RjRGMUI2QUE2MDAwMDAwMDAwMDAwIg0KfQ%3D%3D";
		getFileFromECM(objectId);
	}

	/**
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	private static void getFileFromECM(String objectId) throws IOException, ClientProtocolException {
		// TODO need to add the URL to this method to get the file
		// URL will contain the Object ID of the file
		//TODO with object ID we also need to pass the file location where this need to get stored
		HttpResponse response = getResponseFromECMService(objectId);
		// Building the contents from HttpResponse
		StringBuilder content = buildResponseContent(response);
		String boundaryValue = getBoundaryValue(response);
		// Get File contents from Content
		getFileFromResponseContent(content, boundaryValue);
	}

	/**
	 * @param content
	 * @param boundaryValue
	 */
	private static void getFileFromResponseContent(StringBuilder content, String boundaryValue) {
		String[] strArray = content.toString().split(boundaryValue);
		for (String str : strArray) {
			// System.err.println("value of each string is: "+str);
			if (str.contains("application/octet-stream")) {
				String[] str2 = str.split("application/octet-stream");
				String str3 = str2[1];
				System.err.println("file value is: " + str3);
				// TODO remove this line if we need to get the file to the
				// viewer
				decodedBase64(str3);
				break;
			}
		}
	}

	/**
	 * @param response
	 * @return
	 */
	private static String getBoundaryValue(HttpResponse response) {
		String boundaryValue = "";
		// Getting all headers from HttpResponse
		Header[] header = response.getAllHeaders();

		for (Header head : header) {
			String headerValue = head.getValue().toString();
			System.err.println("header value is: " + headerValue);

			if (headerValue.contains("boundary=")) {
				String[] str = headerValue.split("boundary=");
				// Generally boundary value is set in response with addition of
				// "--"
				boundaryValue = "--" + str[1];
				// System.err.println(str[1]);
				break;
			}
		}
		return boundaryValue;
	}

	/**
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private static StringBuilder buildResponseContent(HttpResponse response) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuilder content = new StringBuilder();
		String line = "";
		// Building response content
		while (null != (line = rd.readLine())) {
			content.append(line);
		}
		return content;
	}

	/**
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	private static HttpResponse getResponseFromECMService(String objectId) throws IOException, ClientProtocolException {
		String userName = "amolugu";
		String password = "ecm";
		@SuppressWarnings("resource")
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"https://ecm-service.psft.co/ecms/documents/"+objectId); // new
		//ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIkZENTVDMEZFQUY4Q0NGNDI4MjhFODIzRjhCMzhBQTlCMDAwMDAwMDAwMDAwIg0KfQ%3D%3D
		// https://ecm-service.psft.co/ecms/documents/ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIkZENTVDMEZFQUY4Q0NGNDI4MjhFODIzRjhCMzhBQTlCMDAwMDAwMDAwMDAwIg0KfQ%3D%3D
		// https://ecm-service.psft.co/ecms/documents/ew0KICAiZGRjTmFtZSIgOiAiRERDX2luZGlhMDEiLA0KICAic3lzUm93SWQiIDogIkMxREZBREY1NzUxMEYwNDQ4OTVBMzg0Nzg1RjA1NEYwMDAwMDAwMDAwMDAwIg0KfQ%253D%253D
		String authString = userName + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		request.addHeader("Authorization", "Basic " + authStringEnc);
		request.addHeader("Accept", "multipart/related");
		request.addHeader("saTenant", "india");
		request.addHeader("saLicense", "1");
		HttpResponse response = client.execute(request);
		return response;
	}

	/**
	 * 
	 * @param ecodedString
	 */
	public static void decodedBase64(String ecodedString) {
		byte[] data = Base64.decodeBase64(ecodedString);
		// TODO add the file where the image needs to be copied too
		try (OutputStream stream = new FileOutputStream("C:/Users/Aditya/Desktop/abc.PNG")) {
			stream.write(data);
		} catch (FileNotFoundException e) {
			System.err.println("File location not found for the file to be written");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

// new HttpGet("http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/");//
// "http://172.26.32.49:8080/InnovationProject/rest/patients/ID310/blooddoc/199"