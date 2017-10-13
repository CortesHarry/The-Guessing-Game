/* 
ClientControllerCLI class. 
The class that implements the ClientController interface. 
To be used in the CLI package, which is the Command-Line Interface version of the game. 
*/
package GuessingGame.CLI;
import GuessingGame.core.*;
import java.util.Scanner;

public class ClientControllerCLI implements ClientController {

	/* 
		Member variables 
	*/
	/* Scanner object, kept as a member variable because of multiple accesses to it. */
	Scanner input = new Scanner(System.in);
	/* Configuration file. Stores allowed attempts data and highest possible guess bound. */
	Configuration config; 

	/* 
		Member methods 
	*/
	/* Main constructor; Need to use this one because I need to have a configuration file.  */
	public ClientControllerCLI (Configuration config) { this.config = config; }
	
	/* nextGuess() method. Returns what the user want to guess next. */
	public int nextGuess() {
		while (true) {
            try {
                System.out.printf("Guess a number between 1 and %d:\n", this.config.getMaxNumber());
                int guess = input.nextInt();
                return guess;
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Try a number, please. ");
                input.nextLine();
           }
        }
	}
	
	/* playAgain() method. Returns whether or not the user would like to replay. */
	public boolean playAgain() {
		System.out.println("Would you like to try again? "); 
		System.out.println("Enter 'y' or 'Y' to confirm! "); 
		String text = input.next();
		if (text.charAt(0) == 'y' || text.charAt(0) == 'Y' ) { return true; }
		else { return false; }
	}
}