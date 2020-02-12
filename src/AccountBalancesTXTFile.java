import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class  AccountBalancesTXTFile {
	private String fileNameAndPath;
	private Boolean hasNextLine = true;


	private Scanner myReader;

	private File fileObject;

	public AccountBalancesTXTFile(String fileNameAndPath){
		this.fileNameAndPath = fileNameAndPath;

		try{
			fileObject = new File(fileNameAndPath);
			myReader = new Scanner(fileObject);
		}
		catch(FileNotFoundException e) {
			System.out.println("An error occurred.");
	      	e.printStackTrace();
		}
		Boolean hasNextLine = myReader.hasNextLine();
	}


	public Map<String, String> readFile() {
		//map.get("name"); // returns "demo"

		String data = myReader.nextLine();

		String account[] = data.split(",");
		String accountName = account[1];
	    String ledgerBalance = account[2];
	    String availableBalance = account[3];

	    System.out.println("Account Name: " + accountName +
		    	", Ledger Balance: " + ledgerBalance +
		    	", Available Balance: " + availableBalance);

		Map<String, String> map = new HashMap<String, String>();
		map.put("accountName", accountName);
		map.put("ledgerBalance", ledgerBalance);
		map.put("availableBalance", availableBalance);

		return map;
	
	}


	public boolean hasNextLine() {
		return this.myReader.hasNextLine();
	}

	public void closeReader() {
		myReader.close();
	}

	public void deleteFileFromStorage() {
		File file = new File(fileNameAndPath); 
          
        if(file.delete()) 
        { 
            System.out.printf("%s File deleted successfully", (fileNameAndPath)); 
        } 
        else
        { 
            System.out.printf("Failed to delete the file %s ", (fileNameAndPath)); 
        }
	}

	public void cleanUp() {
		this.closeReader();
		this.deleteFileFromStorage();
	}

	/*
	public static void main(String[] args) {
		AccountBalancesTXTFile  myFile = new AccountBalancesTXTFile("testfile.txt", "./");
		Map map;
		while(myFile.hasNextLine()) {
			map = myFile.readFile();
			System.out.println(map.get("accountName"));
		}
		myFile.cleanUp();
	}*/

}