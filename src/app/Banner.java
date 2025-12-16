package app;

import java.io.IOException;

public class Banner {
	
	void ClearScreen() {
		String os = System.getProperty("os.name").toLowerCase();
		ProcessBuilder pb;
		
		if (os.contains("win")){
			pb = new ProcessBuilder("cmd","/c","cls	");
		}else {
			pb = new ProcessBuilder("clear");
		}
		
		try {
			pb.inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) { 
			e.printStackTrace();
		}
	}
	
	void showBanner() {
		
		ClearScreen();
		
		System.out.println("         $$");
        System.out.println(" $$$$$$$$$$$$$$$$$$");
        System.out.println(" $$$$$   $$");
        System.out.println(" $$$$$   $$");
        System.out.println(" $$$$$$$$$$$$$$$$$$");
        System.out.println("         $$   $$$$$");
        System.out.println("         $$   $$$$$              Pit Bank v1.0");
        System.out.println(" $$$$$$$$$$$$$$$$$$              Your Productivity Bank");
        System.out.println("         $$");
	}
}
