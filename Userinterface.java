package View;

import java.util.Scanner;

import Model.Car;
import Model.Login;
import Model.Owner;
import Model.User;

public class Userinterface {
	Scanner input = new Scanner(System.in);

	public Userinterface() {
	}

	public void welcomemessage() {
		System.out.println("Welcome to ShareRUs - Carsharing platform" + "\n  ______" + "\n //|_||_\\`.__"
				+ "\n(   _    _ _\\" + "\n=`-(_)--(_)-'");
	}

	public int whoareyou() {
		System.out.println(
				"\n" + " If you are a car owner and want to register your car or manage your car's booking please enter \"1\". "
						+ "\n If you want to book a car or manage your previous bookings please enter \"2\".");
		int userinput = input.nextInt();
		return userinput;
	}

	public int loginorregister() {
		System.out.println(
				"\n To login as existing user please enter \"1\"" + "\n To register as a new user please enter \"2\".");
		int userinput = input.nextInt();
		return userinput;
	}

	public int ownerMenuOverview() {
		System.out.println("\n Welcome to the Owner Menu." + "\n To register a car please enter \"1\"."
				+ "\n To display your cars please enter \"2\"."
				+ "\n To change avaiablitiy of cars please enter \"3\"." + "\n To delete a car please enter \"3\".");
		int userinput = input.nextInt();
		return userinput;
	}

	public int customerMenuOverview() {
		System.out.println("Welcome to the Owner Menu." + "\n To ... please enter \"1\"."
				+ "\n To ... please enter \"2\"."
				+ "\n	To ... please enter \"3\"." + "\n To ... please enter \"4\".");
		int userinput = input.nextInt();
		return userinput;
	}
	
	public void registerCar(){
		System.out.printf("\n\nREGISTER CAR\n", new Object[0]);
		System.out.print("Name of the car: ");
		String name = input.nextLine();

		System.out.printf("\n\n\tTYPE\n", new Object[0]);
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(1), "Sedan" });
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(2), "Convertible" });
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(3), "Sports Car" });
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(4), "SUV" });
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(5), "Other" });
		int typePrompt = input.nextInt();
		String type;
		switch (typePrompt) {
		case 1:
			type = "Sedan";
			break;
		case 2:
			type = "Convertible";
			break;
		case 3:
			type = "Sports Car";
			break;
		case 4:
			type = "SUV";
			break;
		default:
			type = "Other";
		}

		System.out.print("Brand: ");
		String brand = input.next();

		System.out.printf("\n\n\tTRANSMISSION\n", new Object[0]);
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(1), "Manual" });
		System.out.printf("\t  | %-3s | %-15s |\n", new Object[] { Integer.valueOf(2), "Automatic" });
		int transmissionPrompt = input.nextInt();

		String transmission = null;
		switch (transmissionPrompt) {
		case 1:
			transmission = "Manual";
			break;
		case 2:
			transmission = "Automatic";
		}

		System.out.print("Amount of seats: ");
		int seats = input.nextInt();

		System.out.print("Hourly rate: ");
		double rate = input.nextDouble();

		System.out.print("Description: ");
		String description = input.next();

		System.out.print("Location: ");
		String location = input.next();
		
		Owner activeOwner = Login.getActiveOwner();
		int owner = activeOwner.getID();
		Car newCar = new Car(owner, name, type, brand, transmission, seats, rate, description, location);
//		newCar.toDB();
//		Database.cars.add(newCar);
//		newCar.print();
		
	}
}
