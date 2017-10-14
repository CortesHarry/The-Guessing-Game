/* 
Configuration file for the core package of the GuessingGame. 
Holds the highest bound that can be guessed, and how many attempts the player has. 
*/
package GuessingGame.core;

public final class Configuration{

	/* 
		Member variables 
	*/
	/* Holds the largest number that can be guessed.  */
	private int maxNumber;
	/* Holds the number of guess attempts that can be made. */
	private int allowedGuesses; 

	/* 
		Member methods 
	*/
	/* Default Constructor, should not be used at all */
	public Configuration() throws Exception{ throw new Exception("Please do not use the default constructor for the Configuration file. "); }
	
	/* Main Constructor, uses arguments to initialize the maxNumber and the allowedGuesses */
	public Configuration (int maxNumber, int allowedGuesses)  throws Exception {
		if (maxNumber <= 0) { throw new Exception("maxNumber must be above 0."); }
		if (allowedGuesses <= 0) { throw new Exception("allowedGuesses must be above 0."); }
		this.maxNumber = maxNumber;
		this.allowedGuesses = allowedGuesses;
	}

	/* 
		Get-er methods 
	*/
	/* getMaxNumber() method, returns the maxNumber (highest bound that can be guessed) */
    	public int getMaxNumber() { return this.maxNumber; }
	/* getAllowedGuesses() method, returns the allowedGuesses (total attempts that the user gets) */
    	public int getAllowedGuesses() { return this.allowedGuesses; }
}
