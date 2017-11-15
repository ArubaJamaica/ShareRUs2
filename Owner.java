package Model;

public class Owner extends User {
	
private static int ownerid;

public Owner() {
	super();
	ownerid++;
	giveownerid();
}

public void giveownerid(){
	System.out.println("Your Owner ID is: " + ownerid);
	System.out.println("");
}
}