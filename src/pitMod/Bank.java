package pitMod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class Bank {
	
	String usr = System.getProperty("user.name");
	String Date_t = getDate();
	String location = "C:/Users/" + usr + "/Documents/PitBank/";
	File target = new File(location);
	File log = new File(target, Date_t + ".txt");
	
	public String getDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		return today.format(dtf);
	}
	
	public void creatLog() {
		
		
		//Check whether The Directory Exists. If not, Create
		if(!target.exists()) {
			target.mkdirs();
		}
		
		//Merge the File Path and the Main File
		File log = new File(target, Date_t + ".txt");
		
		try {
			if(log.createNewFile()) {
				WriteHeader();
				System.out.println("Statement Created at: " + target);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	void WriteHeader() throws IOException {
		FileWriter fw = new FileWriter(log, true);
		fw.write("PIT BANK STATEMENT\n");
		fw.write("Date: " + Date_t + "\n\n");
		fw.flush();
		fw.close();
	}
}
