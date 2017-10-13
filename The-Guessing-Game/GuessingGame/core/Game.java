/* 

*/
package GuessingGame.core;

public class Game {

	/* 
		Member variables 
	*/
	/* Configuration file. Stores allowed attempts data and highest possible guess bound. */
	private Configuration config; 
	/* ClientController file. Needed to get information from user. */
	private ClientController controller; 
	/* ClientLogic file. Needed to evaluate guesses from the user.  */
	private ClientLogic logic; 
	/* ClientCommunicator file. Needed to present feedback to the user.  */
	private ClientCommunicator communicator;

	/* 
		Member methods 
	*/
	/* Main constructor; need to use this one, otherwise there is no game.  */
	public Game (ClientCommunicator communicator, ClientController controller, ClientLogic logic, Configuration config) {
		this.communicator = communicator; 
		this.config = config; 
		this.logic = logic; 
		this.controller = controller;
	}
	/* Method you invoke to play the game; pure logic of the game */
	public void play() {
		int attempts = config.getAllowedGuesses();
		while (attempts > 0) {
			int guess = this.controller.nextGuess();
			ClientLogic.GGResult result = logic.checkGuess(guess);
			if (result == ClientLogic.GGResult.Correct) {
				communicator.win();
				return;
			}
			else {
				if (attempts == 1) { break; }
				if (result == ClientLogic.GGResult.TooLow) { communicator.tooLow(guess);  }
				else { communicator.tooHigh(guess); }
			}
			attempts--;
		}
		communicator.lose();
	}
}