package database;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

import encryption.EncryptionUtil;
import encryption.EncryptionUtil.EncryptedData;

import java.net.URLEncoder;

public class Database
{
    private HttpClient httpClient;
    private static HttpClient httpClientRead;

	int statusCode;
	String responseBody;
    private final static String URLReadExcursionString = "http://infinitystudiogames.com/booking/readExcursion.php";
    private final String URLRead = "http://infinitystudiogames.com/booking/read.php";
    private final String URLCreate = "http://infinitystudiogames.com/booking/create.php";
	
    public Database() {
    	httpClient = HttpClient.newHttpClient();
    }
    
    public String retrievePlaintextFromAPI() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URLReadExcursionString))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    
    
    public static String databaseReadExcursion() throws Exception
    {
    	httpClientRead = HttpClient.newHttpClient();
   		    HttpRequest request = HttpRequest.newBuilder()
   	                .uri(URI.create(URLReadExcursionString))
					.header("Content-Type", "application/x-www-form-urlencoded")
					.GET()
   	                .build();

   	        HttpResponse<String> response = httpClientRead.send(request, HttpResponse.BodyHandlers.ofString());
   	        System.out.println(response.statusCode());
   	        System.out.println(response.body());
   	        return response.body();
   		     
    } 
    
     public String databaseRead(String user_ID, EncryptionUtil.EncryptedData param2)
     {
    		 try {        
    			 	httpClient = HttpClient.newHttpClient();
    	            String requestBody = "User_ID=" + URLEncoder.encode(user_ID, "UTF-8") +
    	                    "&pass=" + URLEncoder.encode(param2.getInitializationVector(), "UTF-8") + param2.getEncryptedValue().trim();
    	            HttpRequest request = HttpRequest.newBuilder()
    	                    .uri(new URI(URLRead))
    						.header("Content-Type", "application/x-www-form-urlencoded")
    						.POST(BodyPublishers.ofString(requestBody))
    	                    .build();
    	            System.out.println(param2.getInitializationVector().trim() + " " + param2.getEncryptedValue().trim());
    	            System.out.println(requestBody);

    	            HttpResponse<String> resultset = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    	            statusCode = resultset.statusCode();
    				responseBody = resultset.body();
    				HttpHeaders responseHeaders = resultset.headers();
    			
    				// Process the response as needed
    				 System.out.println("Status code: " + statusCode);
    		         System.out.println("Response body: " + responseBody);
    		         System.out.println("Response headers: " + responseHeaders);
    		     
    		         if(statusCode == 500) {
    		        	 JOptionPane.showMessageDialog(null,
    	                         "Internal error 500",
    	                         "Error",
    	                         JOptionPane.ERROR_MESSAGE);
    		         
    	         }else if(statusCode == 405) {
    	        	 JOptionPane.showMessageDialog(null,
    	        			 responseBody,
	                         "Error",
	                         JOptionPane.ERROR_MESSAGE);
    	        	 
    	         }else if(statusCode == 404) {
    	        	 JOptionPane.showMessageDialog(null,
    	        			 "Not found",
	                         "Error",
	                         JOptionPane.ERROR_MESSAGE);
    	        	 
    	         } else if (statusCode == 201) {
    	        	 JOptionPane.showMessageDialog(null,
    	        			 "Problem with confirmation email sending, not registered, please try later.",
	                         "Error",
	                         JOptionPane.ERROR_MESSAGE);
    	        	 
    	         }
    		         return responseBody;
    		         
    		         } 
    		 catch (URISyntaxException | IOException | InterruptedException e) {
    	            e.printStackTrace();
    	        }
    	
    		 return null;
} 

	public int getStatusCode() {
		return statusCode;
	}
	public String getResponseBody() {
		return responseBody;
	}
	
	
	private void getString() {
		try {
            // Create an HttpClient object
            HttpClient httpClient = HttpClient.newHttpClient();

            // Create a URI object for the API endpoint
            URI uri = URI.create("http://example.com/api/getData");

            // Create an HttpRequest object
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            // Send the HTTP request and receive the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Get the response code
            int responseCode = response.statusCode();
            if (responseCode == 200) {
                // Get the response body
                String responseBody = response.body();

                // Process the retrieved data from the database
                System.out.println("Retrieved data from the database: " + responseBody);
            } else {
                System.out.println("HTTP request failed with response code: " + responseCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void insertData(String user_ID, EncryptionUtil.EncryptedData param2, EncryptionUtil.EncryptedData param3, EncryptionUtil.EncryptedData param4, EncryptionUtil.EncryptedData param5, EncryptionUtil.EncryptedData param6, EncryptionUtil.EncryptedData param7, String admin) {
		
		try {
		    String requestBody = "User_ID=" + URLEncoder.encode(user_ID, "UTF-8") +
		        "&pass=" + URLEncoder.encode(param2.getInitializationVector(), "UTF-8") + param2.getEncryptedValue().trim() +
		        "&First_Name=" + URLEncoder.encode(param3.getInitializationVector(), "UTF-8") + param3.getEncryptedValue().trim() +
		        "&Surname=" + URLEncoder.encode(param4.getInitializationVector(), "UTF-8") + param4.getEncryptedValue().trim() +
		        "&Mobile_No=" + URLEncoder.encode(param5.getInitializationVector(), "UTF-8") + param5.getEncryptedValue().trim() +
		        "&Email=" + URLEncoder.encode(param6.getInitializationVector(), "UTF-8") + param6.getEncryptedValue().trim() +
		        "&Cabin_no=" + URLEncoder.encode(param7.getInitializationVector(), "UTF-8") + param7.getEncryptedValue().trim() +
		        "&Admin=" + admin;
			
		    System.out.println("IV: " + param6.getInitializationVector().trim() + "ECV: " + param6.getEncryptedValue().trim());
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(URI.create(URLCreate))
					.header("Content-Type", "application/x-www-form-urlencoded")
					.POST(BodyPublishers.ofString(requestBody))
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			int statusCode = httpResponse.statusCode();
			String responseBody = httpResponse.body();
			HttpHeaders responseHeaders = httpResponse.headers();

			// Process the response as needed
			 System.out.println("Status code: " + statusCode);
	         System.out.println("Response body: " + responseBody);
	         System.out.println("Response headers: " + responseHeaders);
	         
	         if(responseBody.equals("Registration Completed.")) 
	         {
	        	 JOptionPane.showMessageDialog(null,
                         "Registration completed",
                         "Response",
                         JOptionPane.INFORMATION_MESSAGE);
	         }else if(statusCode == 500) {
		        	 JOptionPane.showMessageDialog(null,
	                         "Internal error 500",
	                         "Error",
	                         JOptionPane.INFORMATION_MESSAGE);
		         
	         }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}