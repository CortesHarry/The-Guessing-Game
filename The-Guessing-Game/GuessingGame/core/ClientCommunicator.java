/* 
ClientCommunicator Interface for the core package of the GuessingGame. 
The "View"; what displays information to the player. 
Implement this interface on the class that speaks to the user. 
*/
package GuessingGame.core;

public interface ClientCommunicator {

	/* 
		Member methods 
	*/
	/* Informs the user that they've won */ 
    	void win(); 
	/* Informs the user that they've lost */
   	void lose();
	/* Feedback that tells the user to guess higher */
    	void tooLow(int guess);							
	/* Feedback that tells the user to guess lower */
    	void tooHigh(int guess);
}
