/* 
MainSwing class
Class that contains the main() method for the CLI package.
*/
package GuessingGame.CLI;
import GuessingGame.core.*;

public class MainCLI {

	/*
        Main method
    */
    /* Creates all the necessary files for a Game file to be made and played.  */
	public static void main(String[] args) throws Exception {
		boolean continues = true;
		while (continues) {
			//Construct a configuration file
			Configuration config = new Configuration(16, 4);
			//Construct the logic of the game
			ClientLogic logic = new GameLogic(config);
			//Construct a communicator to the client
			ClientCommunicator communicator = new ClientCommunicatorCLI();
			//Construct a controller from the client
			ClientController controller = new ClientControllerCLI(config);
			//Construct a Game object
			Game guessinggame = new Game(communicator, controller, logic, config);
			//Run the game
			guessinggame.play();
			//Determine if the user would like to play again
			continues = controller.playAgain();
		}
	}
}