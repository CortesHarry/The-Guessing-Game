/* 
GameLogic class that implements the ClientLogic, and will be included in the core package of the GuessingGame. 
Instantiate this class if so that it is this class that handles comparing the guess to the target. 
*/
package GuessingGame.core;
import java.util.Random;
import GuessingGame.core.*;

public class GameLogic implements ClientLogic {

	/* 
		Member variables 
	*/
	/* Data field that holds the ANSWER to the whole game; is not shared with no one. */
	private int target;
	/* Configuration file that we need to access to see what the highest guessing bound is. */
	private Configuration config;
	/* Random object that we need to generate a random guess. */
	private Random generator = new Random();

	/* 
		Member methods 
	*/
	/* Default constructor, error is thrown is Configuration file is not included.  */
	public GameLogic() throws Exception { throw new Exception("Error! Configuration file not included!");  }	
	
	/* Main constructor, error is thrown is Configuration file is not included.  */
    	public GameLogic(Configuration config) { 
		this.config = config; 
		target = generator.nextInt(this.config.getMaxNumber()) + 1; 
	}
	
	/* Logic of the checkGuess() method. Compare the argument to the target, and returns a GGResult type */
	public ClientLogic.GGResult checkGuess (int guess) {
		if (target < guess ) { return ClientLogic.GGResult.TooHigh; }
		else {
			if (target > guess ) { return ClientLogic.GGResult.TooLow; }
			else { return ClientLogic.GGResult.Correct; }
		}
	}
}
