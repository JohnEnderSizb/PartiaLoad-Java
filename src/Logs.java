import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

public class Logs{
	private String endPoint;

	public Logs(String endPoint) {
		this.endPoint = endPoint;
	}

	public static void main(String[] args) {
		Logs lg = new Logs("http://127.0.0.1:8000/partial/log");
		lg.startedLog();
		
	}

	public void startedLog() {
		String message = "Started";
		this.sendLog(message, 1);
	}

	public void finishedLog() {
		String message = "Finished";
		this.sendLog(message, 0);
	}

	public void sendLog(String message, int type) {
		try{
            URL url = new URL(String.format("%s/%s/%s", this.endPoint, message, type));
            //URL url = new URL("http://127.0.0.1:8000/partial/log/java/1");
            System.out.println(url);
        	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestMethod("GET");
		    System.out.println("Logs Request: " + url + " " + connection.getResponseCode());
        	
        } catch (Exception e) {
        	System.out.println("Logs Request: Connection error occured.");
        	System.out.println(e.getMessage());
        }
	}
	
}