import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.File;
//33.8085
public class MainClass {
	public static void main(String[] args) {
		Logs log = new Logs("http://127.0.0.1:8000/partial/log");
		ExecutorService executorService = Executors.newFixedThreadPool(15);

		File balancesFile = new File(args[0]);//commandline argument 1 
		boolean exists = balancesFile .exists();//check if file exists
		if (exists) {
			log.startedLog();
			AccountBalancesTXTFile  myFile = new AccountBalancesTXTFile(args[0]);
			Map map;
			while(myFile.hasNextLine()) {
				map = myFile.readFile();
				System.out.println(map.get("accountName"));

				String accountName = map.get("accountName").toString();
	    		String ledgerBalance = map.get("ledgerBalance").toString();
	    		String availableBalance = map.get("availableBalance").toString();

	    		Account account = new Account(accountName, ledgerBalance, availableBalance);

	    		UpdateRequest updateRequest = new UpdateRequest(args[1], account);

	    		Runnable task = () -> {
	            System.out.println("Executing Task inside : " + Thread.currentThread().getName());
	            	updateRequest.makeGetRequest();
		    		String requestStatus = updateRequest.getRequestStatus();
		    		System.out.println(requestStatus);
	        	};

	        	executorService.submit(task);

			}//while
			myFile.cleanUp();
			executorService.shutdown();
			log.finishedLog();
		}

		else {
			System.out.println("Account Balances File Does Not Exist");
		}

	}
}