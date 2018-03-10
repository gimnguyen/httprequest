package helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import net.sf.json.JSONObject;

public class RequestHelper {

	
	public static ServiceResponse getRequest(String url, String authorization) throws Exception {

		String rawData = "";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("Authorization", "Basic " + authorization);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			// test code
		}
		in.close();

		rawData = response.toString();
		return new ServiceResponse(con.getResponseCode(), rawData);

	}
	
//	POST request
	public static ServiceResponse sendPost(String url, String json) throws Exception {

		HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

		try {

		    HttpPost request = new HttpPost(url);
		    StringEntity params =new StringEntity(json.replace("\r\n", ""));
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);

		    InputStream inData = null;
		    
		    if (response != null) {
                inData = response.getEntity().getContent();
            }
		    
		    String readLine;
		    BufferedReader br = new BufferedReader(new InputStreamReader(inData));
		    StringBuilder responseData = new StringBuilder();
		    
		    while (((readLine = br.readLine()) != null)) {
		    	responseData.append(readLine);
//		    	System.out.println(responseData.toString());		     
		    }
		    
		    int statusCode = response.getStatusLine().getStatusCode();
		    ServiceResponse rawData = new ServiceResponse(statusCode, responseData.toString());

		    return rawData;

		}catch (Exception ex) {
					    
		} finally {
		    
		}
		return null;
	}
	
}
