package homework.wartask;

public class PlayWar {

	private Player firstPlayer;
	private Player secondPlayer;
	private CardDeck gameDeck;
	private Card[] firstPlayerWonCards;
	private Card[] secondPlayerWonCards;

	public PlayWar(String firstPlayerName, String secondPlayerName) {
		setFirstPlayer(new Player(firstPlayerName));
		setSecondPlayer(new Player(secondPlayerName));
		setGameDeck(new CardDeck());
		setFirstPlayerWonCards(new Card[52]);
		setSecondPlayerWonCards(new Card[52]);
	}
	
	public void dealCards() {
		getGameDeck().shuffleDeck();
		Card[] deck = getGameDeck().getDeckOfCards();
		Card[] player1Deck = getFirstPlayer().getPlayerDeck();
		Card[] player2Deck = getSecondPlayer().getPlayerDeck();
		int firstCount = 0;
		int secondCount = 0;

		for (int index = 0; index < deck.length; index++) {
			if (index % 2 == 0 && firstCount < player1Deck.length) {
				player1Deck[firstCount] = deck[index];
				firstCount++;
			} else {
				if (secondCount < player2Deck.length) {
					player2Deck[secondCount] = deck[index];
					secondCount++;
				}
			}
		}

		getFirstPlayer().setPlayerDeck(player1Deck);
		getSecondPlayer().setPlayerDeck(player2Deck);
	}
	
	public void printPlayerDeck(Player player) {
		Card[] deck = player.getPlayerDeck();
		int count = 0;
		for (Card card : deck) {
			System.out.print("\"" + card.getCardValue() + " " + card.getCardSuit() + "\" " + card.getCardPower() + " ");
			count++;
		}
		System.out.println("\n" + count);
	}
	
	public void playWar() {
		Card[] player1Deck = getFirstPlayer().getPlayerDeck();
		Card[] player2Deck = getSecondPlayer().getPlayerDeck();
		Card[] player1WonCardsDeck = getFirstPlayerWonCards();
		Card[] player2WonCardsDeck = getSecondPlayerWonCards();

		int firstPlayerIndex = 0;
		int secondPlayerIndex = 0;

		for (int index = 0; index < player1Deck.length;) {
			if (player1Deck[index].getCardPower() > player2Deck[index].getCardPower()) {
				System.out.println("Player one wins with \" " + player1Deck[index].getCardValue() + " "
						+ player1Deck[index].getCardSuit() + " \"" + " second player card \" "
						+ player2Deck[index].getCardValue() + " " + player2Deck[index].getCardSuit() + " \"");
				player1WonCardsDeck[firstPlayerIndex++] = player1Deck[index];
				player1WonCardsDeck[firstPlayerIndex++] = player2Deck[index];
				index++;
			} else {
				if (player1Deck[index].getCardPower() < player2Deck[index].getCardPower()) {
					System.out.println("Player two wins with \" " + player2Deck[index].getCardValue() + " "
							+ player2Deck[index].getCardSuit() + " \"" + " first player card \" "
							+ player1Deck[index].getCardValue() + " " + player1Deck[index].getCardSuit() + " \"");
					player2WonCardsDeck[secondPlayerIndex++] = player1Deck[index];
					player2WonCardsDeck[secondPlayerIndex++] = player2Deck[index];
					index++;
				} else {
					System.out.println("\nWar on \"" + player1Deck[index].getCardValue() + " "
							+ player1Deck[index].getCardSuit() + "\"" + " and \" " + player2Deck[index].getCardValue()
							+ " " + player2Deck[index].getCardSuit() + " \"!!!"
							+ "\n Now each player has to give three more cards");

					int innerIndex = index + 1;

					while (innerIndex <= index + 3 && innerIndex < player1Deck.length) {
						System.out.println("Player one gives \"" + player1Deck[innerIndex].getCardValue() + " "
								+ player1Deck[innerIndex].getCardSuit() + " \"" + " and player two gives\" "
								+ player2Deck[innerIndex].getCardValue() + " " + player2Deck[innerIndex].getCardSuit()
								+ " \"");
						innerIndex++;
					}
					innerIndex--;
					if (player1Deck[innerIndex].getCardPower() > player2Deck[innerIndex].getCardPower()) {
						System.out.println("First player wins the war and collects the shown cards!");
						while (innerIndex >= index) {
							player1WonCardsDeck[firstPlayerIndex++] = player1Deck[innerIndex];
							player1WonCardsDeck[firstPlayerIndex++] = player2Deck[innerIndex];
							innerIndex--;
						}
						index += 4;
						if (index >= player1Deck.length) {
							break;
						}
					} else {
						if (player1Deck[innerIndex].getCardPower() < player2Deck[innerIndex].getCardPower()) {
							System.out.println("Second player wins the war and collects the shown cards!");
							while (innerIndex >= index) {
								player2WonCardsDeck[secondPlayerIndex++] = player1Deck[innerIndex];
								player2WonCardsDeck[secondPlayerIndex++] = player2Deck[innerIndex];
								innerIndex--;
							}
							index += 4;
							if (index >= player1Deck.length) {
								break;
							}
						} else {

							boolean flag = true;
							while (flag) {
								innerIndex++;
								if (innerIndex < player1Deck.length) {
									if (player1Deck[innerIndex].getCardPower() > player2Deck[innerIndex]
											.getCardPower()) {
										System.out.println("First player wins the war and collects the shown cards!");
										while (innerIndex >= index) {
											player1WonCardsDeck[firstPlayerIndex++] = player1Deck[innerIndex];
											player1WonCardsDeck[firstPlayerIndex++] = player2Deck[innerIndex];
											innerIndex--;
										}
										flag = false;
										index += 4;
										if (index >= player1Deck.length) {
											break;
										}
									} else {
										if (player1Deck[innerIndex].getCardPower() < player2Deck[innerIndex]
												.getCardPower()) {
											System.out.println(
													"Second player wins the war and collects the shown cards!");
											while (innerIndex >= index) {
												player2WonCardsDeck[secondPlayerIndex++] = player1Deck[innerIndex];
												player2WonCardsDeck[secondPlayerIndex++] = player2Deck[innerIndex];
												innerIndex--;
											}
											flag = false;
											index += 4;
											if (index >= player1Deck.length) {
												break;
											}
										}
									}
								} else {
									System.out.println("Decks have finished!");
									flag = false;
									return;
								}
							}
						}

					}
				}
			}
		}
		
		setFirstPlayerWonCards(player1WonCardsDeck);
		setSecondPlayerWonCards(player2WonCardsDeck);
		
	}
	
	
	
	public void evaluateWinner(){
		Card[] player1WonCardsDeck = getFirstPlayerWonCards();
		Card[] player2WonCardsDeck = getSecondPlayerWonCards();
		int firstPlayerWonCount = 0;
		int secondPlayerWonCount = 0; 
		
		for (int index = 0; index < player1WonCardsDeck.length; index++) {
			if (player1WonCardsDeck[index] != null) {
				firstPlayerWonCount++;
			}
		}
		
		for (int index = 0; index < player2WonCardsDeck.length; index++) {
			if (player2WonCardsDeck[index] != null) {
				secondPlayerWonCount++;
			}
		}
		
		if(firstPlayerWonCount > secondPlayerWonCount){
			System.out.println("\nFirst player wins the game with " + firstPlayerWonCount + " cards collected!");
		}else{
			if(secondPlayerWonCount > firstPlayerWonCount){
				System.out.println("\nSecond player wins the game with " + secondPlayerWonCount + " cards collected!");
			}else{
				System.out.println("\nNo one wins the game! Both players have collected the same amount of cards.");
			}
		}
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		if (firstPlayer != null) {
			this.firstPlayer = firstPlayer;
		}
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		if (secondPlayer != null) {
			this.secondPlayer = secondPlayer;
		}
	}

	public CardDeck getGameDeck() {
		return gameDeck;
	}

	public void setGameDeck(CardDeck deckOfCards) {
		if (deckOfCards != null) {
			this.gameDeck = deckOfCards;
		}
	}

	public Card[] getFirstPlayerWonCards() {
		return firstPlayerWonCards;
	}

	public void setFirstPlayerWonCards(Card[] firstPlayerWonCards) {
		if (firstPlayerWonCards != null) {
			this.firstPlayerWonCards = firstPlayerWonCards;
		}
	}

	public Card[] getSecondPlayerWonCards() {
		return secondPlayerWonCards;
	}

	public void setSecondPlayerWonCards(Card[] secondPlayerWonCards) {
		if (secondPlayerWonCards != null) {
			this.secondPlayerWonCards = secondPlayerWonCards;
		}
	}
	
	

}
