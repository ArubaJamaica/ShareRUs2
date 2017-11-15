package View;

import java.util.Scanner;

public class Userinterface {
	Scanner input = new Scanner(System.in);

	public Userinterface() {
	}

	public void welcomemessage() {
		System.out.println("Welcome to ShareRUs - carsharing platform- input text about platform" + "\n  ______"
				+ "\n //|_||_\\`.__" + "\n(   _    _ _\\" + "\n=`-(_)--(_)-'");
	}

	public String whoareyou() {
		System.out.println(
				"\n" + "If you are a car owner and want to register your car or manage your car's booking please enter \"owner\". "
						+ "\nIf you want to book a car or manage your previous bookings please enter \"customer\".");
		String whoamI = input.next();
		return whoamI;
	}

	public int loginorregister() {
		System.out.println(
				"To login as existing user please enter \"1\"." + "\nTo register as a new user please enter \"2\".");
		int userinput = input.nextInt();
		return userinput;
	}
}
