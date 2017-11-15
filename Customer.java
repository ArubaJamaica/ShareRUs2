package Model;

public class Customer extends User {

private static int userid;
	
public Customer () {
	super();
	userid++;
	giveuserid();
}

public void giveuserid(){
	System.out.println("Your User ID is: " + userid);
	System.out.println("");
}
}