package Model;

import java.util.*;


public class Payment {
	Scanner input = new Scanner(System.in);

	// set data variables
	private double amount;
	private String reference;
	private int receipt;

	// constructor
	public Payment(Booking b) {
//		setReceipt();
//		this.amount = b.getBooking_cost();
//		this.reference = b.getBookingReference();
	}

	// ask user for credit card input
	public void creditCard() {
		System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n\t> Enter your credit card data.");
		System.out.println("\t  > Remember: ");
		System.out.println("\t    - We accept only MasterCard and Visa cards.");
		System.out.println("\t    - The expiry date must be in format MM/YYYY");
		System.out.println("\t    - Type \"quit\" at any time to cancel the payment and your reservation.\n");
		boolean number = inputNumberCredit();
		boolean expiryDate = inputExpiryDate();
		boolean cvvCode = inputCvvCode();
		if (number && expiryDate && cvvCode) {
			makePayment();
		}
	}

	// check if creditcard number is right
	private boolean inputNumberCredit() {
		String cardNumber;
		boolean inputcorrect = false;

		do {
			System.out.print("\t  * Card Number (16 digits) ----> ");
			cardNumber = input.nextLine();
			if (cardNumber.equals("quit")) {
				System.out.println("\tWe hope to see you again! Bye :)");
				System.exit(0);
			}
		} while (!checkCardNumber(cardNumber));

		if (!cardNumber.equals("quit") && (cardNumber.length() == 16)) {
			inputcorrect = true;
		}
		return inputcorrect;
	}

	// check if its a Visa or a Mastercard
	private static Boolean checkCardNumber(String cardNumber) {
		String number = new StringBuilder(cardNumber).reverse().toString();
		int sumOdd = 0;
		int sumEven = 0;
		int multiplyEven = 0;
		Boolean validNumber;
		Boolean validVisaOrMc = false;

		for (int i = 0; i < number.length(); i++) {
			int currentDigit = Character.digit(number.charAt(i), 10);
			if (i % 2 == 0) {
				sumOdd += currentDigit;
			} else {
				multiplyEven = currentDigit * 2;
				if (multiplyEven > 9) {
					int d1 = multiplyEven % 10;
					int d2 = multiplyEven / 10;
					sumEven += d1 + d2;
				} else {
					sumEven += multiplyEven;
				}
			}
		}
		validNumber = (sumOdd + sumEven) % 10 == 0;

		if (cardNumber.startsWith("4")) {
			if (cardNumber.length() == 13 || cardNumber.length() == 16 || cardNumber.length() == 19) {
				validVisaOrMc = true;
			}
		} else if (Integer.parseInt(cardNumber.substring(0, 2)) >= 51
				&& Integer.parseInt(cardNumber.substring(0, 2)) <= 55) {
			if (cardNumber.length() == 16) {
				validVisaOrMc = true;
			}
		}

		return validNumber && validVisaOrMc;
	}

	// check if expiry date is right
	private boolean inputExpiryDate() {
		boolean inputcorrect = false;
		String expDate;
		int month;
		int year;
		Boolean dateChecker = false;
		Boolean validMonth = false;
		Calendar c = Calendar.getInstance();
		int yearToday = c.get(Calendar.YEAR);
		int monthToday = c.get(Calendar.MONTH);

		do {
			do {
				System.out.print("\t  * Expiry Date ----> ");
				expDate = input.nextLine();
				if (expDate.equals("quit")) {
					System.out.println("\tWe hope to see you again! Bye :)");
					System.exit(0);
				}
			} while (!expDate.matches("\\d{2}/\\d{4}"));

			month = Integer.parseInt(expDate.substring(0, 2));
			year = Integer.parseInt(expDate.substring(3, 7));
			validMonth = month <= 12 && month >= 0;

			if (year > yearToday && validMonth) {
				dateChecker = true;
			} else if (year == yearToday && month > monthToday && validMonth) {
				dateChecker = true;
			} else if (!validMonth) {
				System.out.println("\t    >> Attention: invalid month entered.");
			} else {
				System.out.println("\t    >> Attention: this credit card is expired.");
			}
		} while (!(dateChecker));

		if (!expDate.equals("quit") && (dateChecker == true)) {
			inputcorrect = true;
		}

		return inputcorrect;
	}

	// check if CVV code is right
	private boolean inputCvvCode() {
		String cvvCode;
		boolean inputcorrect = false;

		do {
			System.out.print("\t  * CVV Code -------> ");
			cvvCode = input.nextLine();
			if (cvvCode.equals("quit")) {
				System.out.println("\tWe hope to see you again! Bye :)");
				System.exit(0);
			}
		} while (!cvvCode.matches("\\d{3}"));

		if (!cvvCode.equals("quit") && (cvvCode.matches("\\d{3}"))) {
			inputcorrect = true;
		}

		return inputcorrect;
	}

	// ask user for mobile payment input
	public void mobilePay() {
		System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n\t> Enter the number of your Mobile Payment Device");
		System.out.println("\t    - Type \"quit\" at any time to cancel the payment and your reservation.\n");
		boolean mpNumber = inputNumberMobile();
		if (mpNumber) {
			makePayment();
		}
	}

	// check if mobile number is correct
	public boolean inputNumberMobile() {
		String mpNumber;
		boolean inputcorrect = false;

		do {
			System.out.print("\t  * Mobile Payment Device number (8 Digits) ----> ");
			mpNumber = input.nextLine();
			if (mpNumber.equals("quit")) {
				System.out.println("\tWe hope to see you again! Bye :)");
				System.exit(0);
			}
		} while (!(mpNumber.length() == 16));

		if (!mpNumber.equals("quit") && (mpNumber.length() == 8)) {
			inputcorrect = true;
		}

		return inputcorrect;
	}

	// ask user for mobile payment input
	public void cash() {
		System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n\t> Please bring chash");
	}

	// simlulating a payment
	public void makePayment() {
		System.out.println("\n\t>> We are processing your payment, please wait. <<");
		System.out.print("\t   Loading..  [");

		for (int i = 0; i < 31; i++) {
			System.out.print("=");
			try {
				Thread.sleep(75);
			} catch (InterruptedException ex) {
				System.out.println("Payment aborted. Exiting...");
				System.exit(0);
			}
		}

		System.out.println("]  OK!\n");
	}

	// calculate a random receipt number
	public void setReceipt() {
		receipt = (int) (Math.random() * 1000000);

	}

	public void setBookingRef(String ref) {
		reference = ref;

	}

	public void setAmount(double price) {
		amount = price;
	}

	// TODO das gleiche mit reference/date/details machen das ich auch mit
	// amount gemacht habe.
	// printing out the reciept
//	public void printOutReceipt() {
//		double VAT = amount * 0.25;
//
//		System.out.println("\n Thank you for your order." + "\n Here is your receipt:" + "\n "
//				+ "\n _____________________________________________________________" + "\n Date: " + b.getDate() + ""
//				+ "\n Booking Reference: " + reference + "" + "\n Receipt Number: " + receipt + ""
//				+ "\n Totalcost of the rental: " + amount + " DKK " + "\n Including VAT: " + VAT + " DKK "
//				+ "\n Details about the booked Bike: " + b.getBikeDetails() + ""
//				+ "\n ______________________________________________________________"
//				+ "\n THANK YOU FOR CHOOSING US!");
//
//	}

}
