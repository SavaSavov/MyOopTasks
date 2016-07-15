package homework.wartask;

public class WarDemo {

	public static void main(String[] args) {
		

		PlayWar newGame = new PlayWar("Sava", "Cecka");
		
		newGame.dealCards();
		
		System.out.println(newGame.getFirstPlayer().getPlayerName());
		newGame.printPlayerDeck(newGame.getFirstPlayer());
		System.out.println();
		System.out.println(newGame.getSecondPlayer().getPlayerName());
		newGame.printPlayerDeck(newGame.getSecondPlayer());
		
		System.out.println();
		newGame.playWar();
		
		newGame.evaluateWinner();
	}

}
