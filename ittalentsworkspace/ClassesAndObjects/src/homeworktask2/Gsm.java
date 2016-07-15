package homeworktask2;

public class Gsm {

	String model;
	boolean hasSimCard;
	String simMobileNumber;
	int outgoingCallsDuration;
	Call lastIncomingCall;
	Call lastOutgoingCall;

	boolean insertSimCard(String simMobileNumber) {

		boolean isNumberOk = true;

		if ((simMobileNumber != null) && (!simMobileNumber.equals("")) && (simMobileNumber.length() == 10)) {
			char firstChar = simMobileNumber.charAt(0);
			char secondChar = simMobileNumber.charAt(1);

			for (int index = 2; index < simMobileNumber.length(); index++) {
				if (simMobileNumber.charAt(index) < '0' || simMobileNumber.charAt(index) > '9') {
					isNumberOk = false;
					break;
				}
			}

			if (firstChar == '0' && secondChar == '8') {

				if (isNumberOk) {
					this.simMobileNumber = simMobileNumber;
					hasSimCard = true;
				} else {

					System.out.println("Invalid input. Mobile number must contain only digits!");
				}

			} else {
				System.out.println("Mobile numbers in Bulgaria start with 08********");
				isNumberOk = false;
			}

		} else {
			System.out.println("Invalid input. Mobile number has to be 10 digits.");
			isNumberOk = false;
		}

		return isNumberOk;

	}

	boolean insertCardWithRegex(String simMobileNumber) {

		boolean isNumberOk = simMobileNumber.matches("((0){1}(8){1}\\d{8})");

		if (isNumberOk) {

			this.simMobileNumber = simMobileNumber;
			hasSimCard = true;

		} else {

			System.out.println("Invalid input. Mobile number must contain 10 digits starting with 08********!");
		}
		
		return isNumberOk;
	}

	void removeSimCard() {

		simMobileNumber = "";
		hasSimCard = false;

	}

	void call(Gsm receiver, int duration) {

		if (validateCall(receiver, duration)) {

			Call lastCall = new Call();
			lastCall.duration = duration;
			lastCall.caller = this;
			lastCall.receiver = receiver;
			receiver.lastIncomingCall = lastCall;
			this.lastOutgoingCall = lastCall;
			this.outgoingCallsDuration += duration;

		}

	}

	boolean validateCall(Gsm receiver, int duration) {

		boolean areNumbersOk = false;

		if (duration > 0 && checkIfCallerNumberIsOk(receiver) && receiver.hasSimCard && this.hasSimCard) {

			areNumbersOk = true;

		}

		return areNumbersOk;
	}

	boolean checkIfCallerNumberIsOk(Gsm receiver) {

		boolean isCallerNumberOk = true;

		if (this.simMobileNumber.equals(receiver.simMobileNumber)) {

			System.out.println("You're trying to call from the same number!!!");
			isCallerNumberOk = false;

		}

		return isCallerNumberOk;
	}

	double getSumForCalls() {

		double sum = outgoingCallsDuration * Call.priceForAMinute;

		return sum;

	}

	void printInfoForTheLastOutgoingCall() {

		StringBuilder sb = new StringBuilder();

		if (lastOutgoingCall != null) {
			sb.append("\nMobile model is: " + lastOutgoingCall.caller.model);
			sb.append("\nand it's number is: " + lastOutgoingCall.caller.simMobileNumber);
			sb.append("\nand last outgoing call duration is: " + lastOutgoingCall.duration);
			sb.append("\nall outgoing calls duration for this number is: "
					+ lastOutgoingCall.caller.outgoingCallsDuration);
			sb.append("\ncurrent bill of the user is: " + lastOutgoingCall.caller.getSumForCalls());
		} else {
			sb.append("There aren't last outgoing calls from this number!");
		}

		System.out.println(sb.toString());
	}

	void printInfoForTheLastIncomingCall() {

		StringBuilder sb = new StringBuilder();

		if (lastIncomingCall != null) {
			sb.append("\nMobile model is: " + lastIncomingCall.receiver.model);
			sb.append("\nand it's number is: " + lastIncomingCall.receiver.simMobileNumber);
			sb.append("\nand last incoming call duration is: " + lastIncomingCall.duration);
			sb.append("\nall outgoing calls duration for this number is: "
					+ lastIncomingCall.receiver.outgoingCallsDuration);
			sb.append("\ncurrent bill of the user is: " + lastIncomingCall.receiver.getSumForCalls());
		} else {
			sb.append("There aren't last incomming calls from this number!");
		}

		System.out.println(sb.toString());
	}

}
