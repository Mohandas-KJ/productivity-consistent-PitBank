package app;

import java.util.Scanner;

import pitMod.*;

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
			System.out.print(System.getProperty("user.name") + ">");
			String cmd = sc.nextLine();
			
			if(cmd.contains("add")) {
				System.out.println("\nAdd Task");
				int currentPit = bank.getPitStatus();
				getUserData(currentPit);
				bank.WriteStatement(currentPit, Domain, Notes, LapTime);
			}
			else if(cmd.contains("help")) {
				bank.helper();
			}
			else if(cmd.contains("exit")) {
				System.out.println("\n\nBye Bye!");
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
