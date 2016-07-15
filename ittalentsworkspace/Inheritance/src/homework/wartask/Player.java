package homework.wartask;

public class Player {
	
	private String playerName;
	private Card[] playerDeck;
	
	public Player(String name){
		setPlayerName(name);
		setPlayerDeck(new Card[26]);
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		if (playerName != null && (!playerName.equals(""))) {
			this.playerName = playerName;
		}
	}

	public Card[] getPlayerDeck() {
		return playerDeck;
	}

	public void setPlayerDeck(Card[] playerDeck) {
		if (playerDeck != null) {
			this.playerDeck = playerDeck;
		}
	}
	
	

}
