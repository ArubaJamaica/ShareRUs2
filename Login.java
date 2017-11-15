package Model;

import java.util.*;

public class Login {
	// create Array
	private ArrayList<Owner> owner = new ArrayList<Owner>();
	private ArrayList<Customer> customer = new ArrayList<Customer>();

	private static Owner activeOwner;
	private static Customer activeCustomer;

	Scanner input = new Scanner(System.in);

	public Login() {
	}

	public void addCustomer(Customer newCustomer) {
		customer.add(newCustomer);
	}

	public void addOwner(Owner newOwner) {
		owner.add(newOwner);
	}

	// method to ask user for Login and check if he logs in right
	public Customer askForLogin(int userType) {
		String password = "";
		String userName = "";
		int numbersOfTries = 3; // The number of tries to log-in.
		int counterTries = 0; // The counter for the loop
		boolean loggedIn = false; // Sentinel value - breaks the loop
		int location;
		do {
			counterTries++;
			System.out.println("Type in your username: ");
			userName = input.nextLine();
			System.out.println("Type in your password: ");
			password = input.nextLine();

			location = checkLoginCredentialsInArrayList(userName, password);
			if ((location != -1)) {
				System.out.println("You are logged in...");
				loggedIn = true;
				if (userType == 1) {
					activeOwner = owner.get(location);
				} else if (userType == 2) {
					activeCustomer = customer.get(location);
				}
			} else {
				System.out.println("You pressed wrong password or username");
			}

		} while (counterTries < numbersOfTries && !loggedIn);
		return (customer.get(location));
	}// method

	// check if in customer data are in array
	public int checkLoginCredentialsInArrayList(String username, String password) {
		int location = -1;

		for (int i = 0; i < customer.size(); i++) {
			if (username.equals(customer.get(i).getUsername())) {
				if (password.equals(customer.get(i).getPassword())) {
					location = i;
					break;
				}
			}
		}

		for (int i = 0; i < owner.size(); i++) {
			if (username.equals(owner.get(i).getUsername())) {
				if (password.equals(owner.get(i).getPassword())) {
					location = i;
					break;
				}
			}
		}
		return location;

	}

	public static Owner getActiveOwner() {
		return activeOwner;
	}

	public static Customer getActiveCustomer() {
		return activeCustomer;
	}
}