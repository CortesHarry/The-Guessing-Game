/*
MainSwing class
Class that contains the main() method for the Swing package.
*/
package GuessingGame.Swing;
import GuessingGame.core.*;
import java.util.concurrent.Semaphore;

public class MainSwing {

    /*
        Member variables
    */
    /* Semaphore that'll be used in the Swing package to pause the game to wait for user input */
    public static final Semaphore available = new Semaphore(0);

    /*
        Main method
    */
    /* Creates all the necessary files for a Game file to be made and played.  */
    public static void main(String[] args) throws Exception {
        boolean continues = true;
        do {
            //Construct a configuration file
            Configuration myConfig = new Configuration(16, 4);
            //Construct the Swing GUIs which are also client controllers and communicators
            ClientSwing myGui = new ClientSwing(myConfig);
            //Construct the logic of the game
            ClientLogic logic = new GameLogic(myConfig);
            //Construct a Game object
            Game myGame = new Game(myGui, myGui, logic, myConfig);
            //Run the game
            myGame.play();
            //Determine if the user would like to play again
            continues = myGui.playAgain();
            //If the user chooses no, then quit the program.
            if (!continues) { System.exit(0); }
        } while (continues);
    }
}
