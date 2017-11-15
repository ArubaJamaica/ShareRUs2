package Control;

import java.util.Scanner;

import Model.Customer;
import Model.Login;
import Model.Owner;
import View.Userinterface;

public class Controller {
	Scanner input = new Scanner(System.in);
	Userinterface userinterface = new Userinterface();
	Login login = new Login();

	public void welcomemessage() {
		userinterface.welcomemessage();
	}

	public void whoareyou() {
		boolean checkinput = false;
		String menuChoice = "";
		do {
			switch (userinterface.whoareyou()) {
			case "owner":
				loginorregisterOwner();
				checkinput = true;
				menuChoice = "owner";
				break;

			case "customer":
				loginorregisterCustomer();
				checkinput = true;
				menuChoice = "customer";
				break;
			default:
				userinterface.whoareyou();
			}

		} while (!checkinput);

		if (menuChoice == "owner") {
			ownerMenuOverview();
		} else if (menuChoice == "customer") {
			customerMenuOverview();
		}
	}

	public void loginorregisterCustomer() {
		boolean checkinput = false;
		do {
			switch (userinterface.loginorregister()) {
			case 1:
				login.askForLogin();
				checkinput = true;
				break;
			case 2:
				Customer customer = new Customer();
				login.addCustomer(customer);
				checkinput = true;
				break;
			default:
				userinterface.loginorregister();
			}
		} while (!checkinput);
	}

	public void loginorregisterOwner() {
		boolean checkinput = false;
		do {
			switch (userinterface.loginorregister()) {
			case 1:
				login.askForLogin();
				checkinput = true;
				break;

			case 2:
				Owner owner = new Owner();
				login.addOwner(owner);
				checkinput = true;
				break;
			default:
				userinterface.loginorregister();
			}
		} while (!checkinput);
	}

	public void ownerMenuOverview() {
	}

	public void customerMenuOverview() {
	}

}
