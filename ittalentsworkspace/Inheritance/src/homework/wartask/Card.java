package homework.wartask;

public class Card {
	
	private String cardSuit;
	private String cardValue;
	private int cardPower;
	
	public Card(String cardSuit, String cardValue, int cardPower) {
		setCardSuit(cardSuit);
		setCardValue(cardValue);
		setCardPower(cardPower);
	}

	public String getCardSuit() {
		return cardSuit;
	}

	public void setCardSuit(String cardSuit) {
		if (cardSuit != null) {
			if (cardSuit.equalsIgnoreCase("spades") || cardSuit.equalsIgnoreCase("diamond")
					|| cardSuit.equalsIgnoreCase("hearts") || cardSuit.equalsIgnoreCase("club")) {
				this.cardSuit = cardSuit;
			} else {
				System.out.println("There isn't that kind of card suit!!!");
			}
		}
	}

	public String getCardValue() {
		return cardValue;
	}

	public void setCardValue(String cardValue) {
		if (cardValue != null && (!cardValue.equals(""))) {
			this.cardValue = cardValue;
		}
	}

	public int getCardPower() {
		return cardPower;
	}

	public void setCardPower(int cardPower) {
		if (cardPower >= 0 && cardPower <= 12) {
			this.cardPower = cardPower;
		}
	}

}
