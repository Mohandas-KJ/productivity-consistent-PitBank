package pitMod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class Bank {
	
	//General Variables
	String usr = System.getProperty("user.name");
	String Date_t = getDate();
	String location = "C:/Users/" + usr + "/Documents/PitBank/";
	File target = new File(location);
	File log = new File(target, Date_t + ".txt");
	
	//Used to get System Date
	public String getDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		return today.format(dtf);
	}
	
	//Used to create Directory and Statement File
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
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//Used to create Header on start
	void WriteHeader() throws IOException {
		FileWriter fw = new FileWriter(log, true);
		fw.write("PIT BANK STATEMENT\n");
		fw.write("Date: " + Date_t + "\n\n");
		fw.flush();
		fw.close();
	}
	
	//Used to get the current Time Block(Pit Stop from the file)
	public int getPitStatus() {
		int pitStop = 0;
		try {
			FileReader fr = new FileReader(log);
			BufferedReader bf = new BufferedReader(fr);
			String line;
			
			
			while((line = bf.readLine()) != null) {
				if(line.startsWith("PIT STOP")) {
					pitStop = Integer.parseInt(line.split(" ")[2]);
				}
			}
			
			bf.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return pitStop+1;
	}
	
	//Used to write the Logs to the File
	public void WriteStatement(int currentPit, String Domain, String Note, String tb) {
		int[] locker = {10,5,3,1};
		
		try {
			FileWriter fw = new FileWriter(log,true);
			
			fw.write("--------------------------\n");
			fw.write("PIT STOP " + currentPit + "\n");
			fw.write("Domain: " + Domain + "\n");
			fw.write("Lap Time: " + tb + "\n");
			fw.write("Notes: " + (Note != null ? Note + "\n":"none" + "\n"));
			
			if(Domain.toLowerCase().equals("cybersecurity")) {
				fw.write("Sponsor Payout: $" + locker[0] + "M\n");
			}
			else if(Domain.toLowerCase().equals("android kotlin")) {
				fw.write("Sponsor Payout: $" + locker[2] + "M\n");
			}
			else if(Domain.toLowerCase().equals("f1 prediction")) {
				fw.write("Sponsor Payout: $" + locker[2] + "M\n");
			}
			else if(Domain.toLowerCase().equals("dsa")) {
				fw.write("Sponsor Payout: $" + locker[3] + "M\n");
			}
			else if(Domain.toLowerCase().equals("stock market")) {
				fw.write("Sponsor Payout: $" + locker[1] + "M\n");
			}
			else if(Domain.toLowerCase().equals("typescript")) {
				fw.write("Sponsor Payout: $" + locker[3] + "M\n");
			}
			else {
				fw.write("Sponsor Payout: $" + locker[3] + "M\n");
			}
			fw.write("--------------------------\n\n");
			fw.close();
			
			System.out.println("Statement Created at: " + log);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void helper() {
		System.out.println("\nWecome to Help Assistant");
		System.out.println("PIT BANK INC. 2025");
		System.out.println("\nThis application is to encourage the people who wish to be disciplined in their own way.");
		System.out.println("We\'re here to make you a Virtual Millionare. This application awards you Virtual Dollars for every Disciplined work");
		System.out.println("To Know more approach the GitHub page of Pit Bank Application");
		System.out.println("\nCommands Supported:");
		System.out.println("1. add [pitstop/statement/task/...] - Records the task and awards Sponsors");
		System.out.println("2. calculate [total/task] - Returns the total Payout Today or Gives the Total Task Completed Correspondingly\n");
	}
	
	public int CalculateTotal() {
		
		int Total_Payout = 0;
		
		try {
			
			FileReader sp_reader = new FileReader(log);
			BufferedReader bf_payout = new BufferedReader(sp_reader);
			
			String line;
			
			while((line = bf_payout.readLine()) != null) {
				if(line.startsWith("Sponsor Payout")) {
					String tmp = line.split("\\$")[1];
					int temp_cal = Integer.parseInt(tmp.substring(0,tmp.length() - 1));
					Total_Payout += temp_cal;
				}
			}
			
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		return Total_Payout;
		
		
	}
	
}
