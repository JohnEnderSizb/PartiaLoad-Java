import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

public class UpdateRequest {
	private String destination;
	private Account theAccount;
	private String requestStatus;
	private String fullUrl;

	public UpdateRequest(String destination, Account theAccount) {
		this.destination = destination;
		this.theAccount = theAccount;
		this.requestStatus = "The request has not been made yet.";
		this.fullUrl = String.format("%s/%s/%s/%s", 
				destination, 
				theAccount.getAccountName(), 
				theAccount.getLedgerBalance(), 
				theAccount.getAvailableBalance()
			); //destination/accountName/ledgerBalance/availableBalance
	}

    public void makeGetRequest() { //make the get request to the provided destination
        try{
            URL url = new URL(this.fullUrl);
        	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
        	this.requestStatus = connection.getResponseCode() +" : " + fullUrl;
        } catch (Exception e) {
        	System.out.println("Connection error occured.");
        }
        
    }

    public String getRequestStatus() {
    	return this.requestStatus;
    }

    public static void main(String[] args) {
    	//testing
    	try{
            URL url = new URL("https://tecadmin.net/install-oracle-java-8-ubuntu-via-ppa/");
        	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
		    System.out.println(connection.getResponseCode());
        	
        } catch (Exception e) {
        	System.out.println("Connection error occured.");
        }
    }
}
