package Client.request;

public class ServiceResponse {

	private int statusCode;
	private String rawData;
	
	public ServiceResponse(int statusCode, String rawData){
		this.statusCode = statusCode;
		this.rawData = rawData;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getRawdata() {
		return rawData;
	}
	public void setRawdata(String rawdata) {
		rawData = rawdata;
	}
}
