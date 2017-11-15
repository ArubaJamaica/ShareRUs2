package Control;

import java.util.Scanner;

import Model.Car;
import Model.Customer;
import Model.Login;
import Model.Owner;
import Model.User;
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
			case 1:
				loginorregisterOwner();
				checkinput = true;
				menuChoice = "owner";
				break;

			case 2:
				loginorregisterCustomer();
				checkinput = true;
				menuChoice = "customer";
				break;
			default:
				break;
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
				login.askForLogin(2);
				checkinput = true;
				break;
			case 2:
				Customer customer = new Customer();
				login.addCustomer(customer);
				checkinput = true;
				break;
			default:
				break;
			}
		} while (!checkinput);
	}

	public void loginorregisterOwner() {
		boolean checkinput = false;
		do {
			switch (userinterface.loginorregister()) {
			case 1:
				login.askForLogin(1);
				checkinput = true;
				break;

			case 2:
				Owner owner = new Owner();
				login.addOwner(owner);
				checkinput = true;
				break;
			default:
				break;
			}
		} while (!checkinput);
	}

	public void ownerMenuOverview() {
		boolean checkinput = false;
		do {
			switch (userinterface.ownerMenuOverview()) {
			case 1:
				userinterface.registerCar();
				checkinput = true;
				break;
//			case 2:
//				displayCar();
//				checkinput = true;
//				break;
//			case 3:
//				changeCarAvaiablity();
//				checkinput = true;
//				break;
//			case 4:
//				deleteCar();
//				checkinput = true;
//				break;
			default:
				break;
			}
		} while (!checkinput);
	}

	public void customerMenuOverview() {
		boolean checkinput = false;
		do {
			switch (userinterface.customerMenuOverview()) {
			case 1:
				checkinput = true;
				break;
			case 2:
				checkinput = true;
				break;
			case 3:
				checkinput = true;
				break;
			default:
				break;
			}
		} while (!checkinput);
	}

}
