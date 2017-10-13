/*
ClientSwing class.
The class that implements the ClientCommunicator and the ClientController interface.
To be used in the Swing package, which uses the Swing graphical user interface class.
*/
package GuessingGame.Swing;
import GuessingGame.core.*;

public class ClientSwing implements ClientController, ClientCommunicator {

    /*
        Member variables
    */
    /* GuessingGameGUI object that holds the window for the main screen */
    private GuessingGameGUI gamescreen;
    /* PlayAgainGUI object that holds the window for the try again screen */
    private PlayAgainGUI tryagainscreen;
    /* Configuration file. Stores allowed attempts data and highest possible guess bound. */
    private Configuration config;

    /*
        Member methods
    */
    /* Main constructor for this class; requires a Configuration file.  */
    public ClientSwing (Configuration config) {
        this.config = config;
        gamescreen = new GuessingGameGUI(this.config);
        tryagainscreen = new PlayAgainGUI();
    }

    /*
        Definitions of the ClientController interface methods
    */
    /* Asks the user what their guess is. */
    public int nextGuess() {
        try {
            //Acquire the semaphore so that we can wait for the user input
            MainSwing.available.acquire();
        } catch (Exception e) {}
        //Once the user hits "Submit", the data is stored and the semaphore is released
        return gamescreen.returnGuess();
    }

    /* Asks the user if they'd like to play again. */
    public boolean playAgain() {
        try {
            //Switch the screens before you hold the progress.
            switchScreens();
            //Acquire the semaphore so that we can wait for the user input
            MainSwing.available.acquire();
        } catch (Exception e) {}
        //Once the user hits "Submit", the data is stored and the semaphore is released
        return tryagainscreen.getTryAgainValue();
    }

    /*
        Definitions of the ClientCommunicator interface methods
    */
    /* Informs the user that they've won */
    public void win() {
        gamescreen.setFeedbackWon();
        gamescreen.playWin();
        //Sleep the thread to give the player a chance to read if he won/lost
        try { Thread.sleep(2250); }
        //Ignore the exception, serves only as a timer to display the feedback.
        catch (Exception ignored) {}
    }

    /* Informs the user that they've lost */
    public void lose() {
        gamescreen.setFeedbackLost();
        gamescreen.playLose();
        //Sleep the thread to give the player a chance to read if he won/lost
        try { Thread.sleep(2250); }
        //Ignore the exception, serves only as a timer to display the feedback.
        catch (Exception ignored) {}
    }

    /* Feedback that tells the user to guess higher */
    public void tooLow(int guess) {
        gamescreen.setFeedbackLow();
        gamescreen.playError();
    }

    /* Feedback that tells the user to guess lower */
    public void tooHigh(int guess) {
        gamescreen.setFeedbackHigh();
        gamescreen.playError();
    }

    /* Switches between the main screen and the play again screen */
    private void switchScreens() {
        if (gamescreen.returnMainscreen().isVisible()) {
            gamescreen.turnOffMainAgainScreen();
            tryagainscreen.turnOnTryAgainScreen();
        } else {
            gamescreen.turnOnMainAgainScreen();
            tryagainscreen.turnOffTryAgainScreen();
        }
    }
}
