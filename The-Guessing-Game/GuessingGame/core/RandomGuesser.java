/* 
RandomGuesser class that will be included in the core package of the GuessingGame. 
Instantiate this class if you'd like the computer to be playing the guessing game. 
*/
package GuessingGame.core;
import java.util.Random;

public class RandomGuesser implements ClientController {

	/* 
		Member variables 
	*/
	/* Random object that we need to generate a random guess. */
    	private Random rand = new Random();
	/* Configuration file that we need to access to see what the highest guessing bound is. */
    	private Configuration config;

	/* 
		Member methods 
	*/
	/* Default constructor, error is thrown is Configuration file is not included.  */
	public RandomGuesser() throws Exception { throw new Exception("Error! Configuration file not included!");  }
	/* Main constructor, error is thrown is Configuration file is not included.  */
	public RandomGuesser(Configuration config) { this.config = config; }
	/* Randomized nextGuess() method; uses Random class to guess a random value.  */
    	public int nextGuess() { return this.rand.nextInt(config.getMaxNumber()) + 1; }
	/* Randomized playAgain() method; uses Random class to guess whether or not the computer wants to play again.  */
	public boolean playAgain() { return this.rand.nextInt(1) == 0; }
}
