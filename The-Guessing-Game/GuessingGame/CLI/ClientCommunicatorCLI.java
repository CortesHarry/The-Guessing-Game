/* 
ClientCommunicatorCLI class. 
The class that implements the ClientCommunicator interface. 
To be used in the CLI package, which is the Command-Line Interface version of the game. 
*/
package GuessingGame.CLI;
import GuessingGame.core.*;

public class ClientCommunicatorCLI implements ClientCommunicator {

	/* 
		Member methods 
	*/
	/* Informs the user that they've won */
    	public void win(){ System.out.println("Congrats! You've won!"); }
	/* Informs the user that they've lost */
	public void lose() { System.out.println("Oh no! It's a gameover!"); }
	/* Sets the welcome message again */
	public void reset() { System.out.println("Welcome to the GuessingGame!"); }
	/* Feedback that tells the user to guess higher */
	public void tooLow(int guess) { System.out.println("Your guess of " + guess + " was too low. Try a little higher!"); }
	/* Feedback that tells the user to guess lower */
	public void tooHigh(int guess) { System.out.println("Your guess of " + guess + " was too high. Try a little lower!"); }
}
