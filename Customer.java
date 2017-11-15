package Model;

public class Customer extends User {

	private static int customerid;

	public Customer() {
		super();
		customerid++;
		giveuserid();
	}

	public void giveuserid() {
		System.out.println("Your User ID is: " + customerid);
		System.out.println("");
	}

	public int getID() {
		return customerid;
	}

}