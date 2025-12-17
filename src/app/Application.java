package app;

import java.util.Scanner;
import pitMod.*; //Import of another package

public class Application {
	
	String Domain, LapTime, Notes;
	
	public void getUserData(int currentPit) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nPIT STOP " + currentPit);
		System.out.print("Domain: ");
		Domain = sc.nextLine();
		System.out.print("Lap Time: ");
		LapTime = sc.nextLine();
		System.out.print("Notes: ");
		Notes = sc.nextLine();
		
	}
	
	public void CLIController() {
		
		Scanner sc = new Scanner(System.in);
		
		Bank bank = new Bank();
		
		do {
			System.out.print("\n" + System.getProperty("user.name") + "> ");
			String cmd = sc.nextLine();
			
			if(cmd.toLowerCase().contains("add")) {
				System.out.println("\nAdd Task");
				int currentPit = bank.getPitStatus();
				getUserData(currentPit);
				bank.WriteStatement(currentPit, Domain, Notes, LapTime);
			}
			else if(cmd.toLowerCase().contains("help")) {
				bank.helper();
			}
			else if(cmd.toLowerCase().contains("calculate") && cmd.toLowerCase().contains("total")) {
				int Balance = bank.CalculateTotal();
				
				if(Balance != 0) {
					System.out.println("Total Payout: $" + Balance + "M");
				}
				else {
					System.out.println("No PayOut Yet! Keep Working");
				}
			
			}
			else if(cmd.toLowerCase().contains("calculate") && cmd.toLowerCase().contains("task")) {
				int com_task = bank.getPitStatus() -1;
				
				if(com_task != 0) {
					System.out.println("Completed Task: " + com_task);
					System.out.println("Keep Going!");
				}
				else {
					System.out.println("No Tasks Yet! Keep Pushing!");
				}
			}
			else if(cmd.toLowerCase().contains("exit")) {
				System.out.println("\n\nBye Bye!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) { e.printStackTrace(); }
				System.exit(0);
			}
			
		}while(true);
		
	}

	public static void main(String[] args) {
		
		
		
		Bank bank = new Bank();
		Banner ban = new Banner();
		Application app = new Application();
		
		ban.showBanner();
		bank.creatLog();
		
		System.out.println("\n\nWelcome to Pit Bank CLI. If you need help run the help command");
		app.CLIController();
		
		

	}

}
