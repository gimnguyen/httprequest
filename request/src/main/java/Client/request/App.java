package Client.request;

public class App 
{
    public static void main( String[] args )
    {
        String url = "http://jsonplaceholder.typicode.com/comments?postId=1";
        ServiceResponse response = RequestHelper.getRequest(url);
        
        System.out.println(response.getRawdata());
        
    }

}
