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

	public static void main(String[] args) {
		
		
		
		Bank bank = new Bank();
		Banner ban = new Banner();
		Application app = new Application();
		
		ban.showBanner();
		bank.creatLog();
		
		int currentPit = bank.getPitStatus();
		app.getUserData(currentPit);
		
		bank.WriteStatement(currentPit, app.Domain, app.Notes, app.LapTime);
		
		

	}

}
