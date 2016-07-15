package homeworktask2;

import java.util.Scanner;

public class GsmCallTest {
	
	static Scanner input;

	public static void main(String[] args) {

		Gsm samsung = null;
		Gsm motorolla = null;
		Gsm nokia = null;

		System.out.println("Enter data for the caller: ");
		
		samsung = fillDataForGsmUser();

		do {
			
			System.out.println("\nEnter data for the first receiver:");
			motorolla = fillDataForGsmUser();

		} while (!(samsung.checkIfCallerNumberIsOk(motorolla)));


		samsung.call(motorolla, 10);

		samsung.printInfoForTheLastOutgoingCall();

		motorolla.printInfoForTheLastIncomingCall();
		

		do {
			
			System.out.println("\nEnter data for the next receiver:");
			
			nokia = fillDataForGsmUser();

		} while (!(samsung.checkIfCallerNumberIsOk(nokia)));
		

		samsung.call(nokia, 5);

		samsung.printInfoForTheLastOutgoingCall();

		nokia.printInfoForTheLastIncomingCall();
		
		nokia.call(samsung, 15);
		
		nokia.printInfoForTheLastOutgoingCall();

		samsung.printInfoForTheLastIncomingCall();

		input.close();
	}
	
	static Gsm fillDataForGsmUser(){
		
		input = new Scanner(System.in);
		Gsm gsmUser = new Gsm();
		
		String number;
		String model;

		do{

			System.out.println("Enter number for the mobile phone:");
			number = input.next();

		} while (!gsmUser.insertSimCard(number));

		System.out.println("Enter model for the mobile phone:");
		model = input.next();

		gsmUser.model = model;

		return gsmUser;
	}

}
