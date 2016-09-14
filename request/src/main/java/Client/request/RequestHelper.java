package Client.request;

import java.io.IOException;
import java.io.InputStream;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class RequestHelper {

	static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	
	public static ServiceResponse getRequest(String url) {
        GenericUrl gUrl = new GenericUrl(url);
        HttpRequest request;
        HttpResponse response = null;
        String rawData = null;
        
		try {
			request = HTTP_TRANSPORT.createRequestFactory().buildGetRequest(gUrl);
//			request.getHeaders().setAuthorization(authorization);
			request.getHeaders().set("api-key", "7ab27fe6bb0e16836d6ee3e939856d49");
			
			HttpHeaders headers = new HttpHeaders();
			headers.entrySet();
			
			
			request.setHeaders(headers);
			
			System.out.println("HD: " + request.getHeaders().toString());
			
			response = request.execute();
	        
	        InputStream is = response.getContent();
	        
	        int ch;
	        StringBuilder builder = new StringBuilder();
	        
	        while ((ch = is.read()) != -1) {
	            builder.append((char)ch);
	        }

	        rawData = builder.toString();
	        response.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return new ServiceResponse(response.getStatusCode(), rawData);
    }
	
}
