package Client.request;

import java.io.IOException;
import java.io.InputStream;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class ReqestHelper {

	static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	
	public static ServiceResponse getRequest(String reqUrl) throws IOException {
        GenericUrl url = new GenericUrl(reqUrl);
        HttpRequest request = HTTP_TRANSPORT.createRequestFactory().buildGetRequest(url);
        HttpResponse response = request.execute();
        
        InputStream is = response.getContent();
        
        int ch;
        StringBuilder builder = new StringBuilder();
        
        while ((ch = is.read()) != -1) {
            builder.append((char)ch);
        }

        String data = builder.toString();
        response.disconnect();
        return new ServiceResponse(response.getStatusCode(), data);
    }
	
}
