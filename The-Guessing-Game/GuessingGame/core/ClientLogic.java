/* 
ClientLogic Interface for the core package of the GuessingGame. 
The "Logic"; compares the user's guess to the target being guessed. 
Implement this interface on the class that handles the comparisons, which will be included in the core package. 
*/
package GuessingGame.core;

public interface ClientLogic {

	/* 
		Member Enumerators 
	*/
	/* GuessingGameResult enums. */
	public enum GGResult {
		Correct, 
		TooHigh, 
		TooLow,
	}

	/* 
		Member methods 
	*/	
	/* Returns a value of "Correct", "TooHigh", or "TooLow" after checking the guessed value. */
	public GGResult checkGuess(int guess);
}
