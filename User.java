package Model;

import java.util.Scanner;

public class User {

	// Activate Scanner
	Scanner input = new Scanner(System.in);

	// create data fields
	private String firstname, lastname, address, dateofbirth, telephone, cpr, username, password;
	private int postcode;

	public User() {
		firstname = setfirstname();
		lastname = setlastname();
		address = setaddress();
		postcode = setpostcode();
		dateofbirth = setdateofbirth();
		telephone = settelephone();
		cpr = setcpr();
		username = setUsername();
		password = setPassword();
		givelogindetails();
	}

	// constructor
	public User(String firstname, String lastname, String address, int postcode, String dateofbirth, String telephone,
			String cpr, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.postcode = postcode;
		this.dateofbirth = dateofbirth;
		this.telephone = telephone;
		this.cpr = cpr;
		this.username = username;
		this.password = password;
	}
	// getter methods for data fields above

	public String getfirstname() {
		return firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public String getaddress() {
		return address;
	}

	public int getpostcode() {
		return postcode;
	}

	public String getdateofbirth() {
		return dateofbirth;
	}

	public String gettelephone() {
		return telephone;
	}

	public String getcpr() {
		return cpr;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	// setter methods for data fields
	// method to take details from the customer
	// Prompt user to input the personal information and store them in the

	public String setfirstname() {
		System.out.print("Enter your first name : ");
		firstname = input.nextLine();

		return firstname;
	}

	public String setlastname() {
		System.out.print("Enter your last name name : ");
		lastname = input.nextLine();
		return lastname;
	}

	public String setaddress() {
		System.out.print("Please enter your street name and number in one line : ");
		address = input.nextLine();
		return address;
	}

	public int setpostcode() {

		System.out.print("Postcode (needs to be Copenhagen area): ");
		postcode = input.nextInt();

		while (postcode >= 2501 || postcode < 1000) {
			System.out.print("Postcode needs to be in Copenhagen area (4 digits). Please enter again: ");
			postcode = input.nextInt();
		}
		return postcode;
	}

	// TODO: Übertreibs nicht mit dem Coden hier und
	// TODO: vergenies gefälligst die Zeit mit deiner Family :)

	public String setdateofbirth() {
		System.out.print("Date of birth (Format: DD.MM.YYYY): ");
		dateofbirth = input.next();

		while (!dateofbirth.matches("\\d{2}.\\d{2}.\\d{4}")) {
			System.out.print("Please enter your DOB in the format DD.MM.YYYY: ");
			dateofbirth = input.next();
		}
		return dateofbirth;
	}

	public String settelephone() {

		System.out.print("Telephone number (8-digit danish number): ");
		telephone = input.next();

		while (!telephone.matches("\\d{8}")) {
			System.out.print("Please enter a danish telephone number with 8 digits: ");
			telephone = input.next();
		}
		return telephone;
	}

	public String setcpr() {
		System.out.print("CPR number (Format: 123456-1234): ");
		cpr = input.next();

		while (!cpr.matches("\\d{6}-\\d{4}")) {
			System.out.print("Please enter your CPR number in the right format (123456-1234): ");
			cpr = input.next();
		}
		return cpr;
	}

	public String setUsername() {
		username = firstname.substring(0, 1) + lastname.substring(0, 3);
		return username;
	}

	public String setPassword() {
		password = lastname.substring(0, 3) + cpr.substring(cpr.length() - 4);
		return password;
	}

	public void givelogindetails() {
		System.out.println("");
		System.out.println("Thank you!");
		System.out.println("Your username is: " + username);
		System.out.println("Your password is: " + password);
	}

}
