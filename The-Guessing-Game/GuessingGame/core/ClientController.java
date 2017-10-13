/* 
ClientController Interface for the core package of the GuessingGame. 
The "Controller"; what requests information from the user. 
Implement this interface on the class that gets data from the user. 
*/
package GuessingGame.core;

public interface ClientController {

	/* 
		Member methods 
	*/
	/* Asks the user what their guess is. */
    int nextGuess(); 
	/* Asks the user if they'd like to play again. */
    boolean playAgain();
}