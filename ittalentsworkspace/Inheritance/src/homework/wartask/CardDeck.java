package homework.wartask;

public class CardDeck {
	
	private final String[] suit = {"club", "diamond", "hearts", "spades"};
	private final String[] value = {"2", "3", "4", "5", "6", "7", "8","9", "10",
			"J", "Q", "K", "A"};
	private Card[] deckOfCards;
	
	public CardDeck() {
		setDeckOfCards(new Card[52]);
		
		int index = 0;

			for (int indexI = 0; indexI < suit.length; indexI++) {
				for (int indexJ = 0; indexJ < value.length && index < 52; indexJ++) {

					deckOfCards[index++] = new Card(suit[indexI], value[indexJ], indexJ);
				}
			}
	}
	
	public void printDeck(){
		
		int count = 0;
		
		for (Card card : getDeckOfCards()) {
			System.out.print("\""+card.getCardValue() + " " + card.getCardSuit() + "\" " + card.getCardPower() + " ");
			count++;
			
			if(count == 13){
				System.out.println();
				count = 0;
			}
		}
		
	}
	
	public void shuffleDeck(){
		
		Card[] deck = getDeckOfCards();
		
		for (int index = 0; index < deck.length; index++) {
			int randonIndex = ((int)(Math.random() * (52))) + 0;
			Card temp = deck[randonIndex];
			deck[randonIndex] = deck[index];
			deck[index] = temp;

		}
		
		setDeckOfCards(deck);
	}

	public Card[] getDeckOfCards() {
		return deckOfCards;
	}

	public void setDeckOfCards(Card[] deckOfCards) {
		if (deckOfCards != null) {
			this.deckOfCards = deckOfCards;
		}
	}
	
	

}
