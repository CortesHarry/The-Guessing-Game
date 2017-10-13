/*
PlayAgainGUI class.
Class that holds the Swing window information for the try again screen of the Guessing Game
*/
package GuessingGame.Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayAgainGUI {

	/*
		Member variables
	*/
	/* Window that holds the information for the try again Guessing Game screen */
    private JFrame tryAgainScreen;
    /* Field that holds the value of whether or not the player is replaying.  */
    private boolean tryAgainValue;

	/*
		Member methods:
		    Important methods
	*/
    /* Default and main constructor; creates an invisible "try again" window */
	public PlayAgainGUI () { CreateAndAddComponents(); }
    /* Returns the JFrame of the try again window*/
    public JFrame getTryAgainScreen() {return tryAgainScreen; }
    /* Use this method to answer whether or not the user wants to play again */
    public boolean getTryAgainValue() {return tryAgainValue; }
    /* Use this method to SHOW the try again screen */
    public void turnOnTryAgainScreen() {tryAgainScreen.setVisible(true);}
    /* Use this method to HIDE the try again screen */
    public void turnOffTryAgainScreen() {tryAgainScreen.setVisible(false);}
    /* Method used to create the Swing components */
    private void CreateAndAddComponents() {
        //Create the components
        tryAgainScreen = createFrame();
        JLabel mainLabel = createMainLabel();
        JButton yesButton = createYesButton();
        JButton noButton = createNoButton();
        JPanel butsPanel = createButtonPanel();
        //Add buttons to the button panel
        butsPanel.add(yesButton);
        butsPanel.add(noButton);
        //Add the label and the buttons to the window
        tryAgainScreen.add(mainLabel);
        tryAgainScreen.add(butsPanel);
        //This window starts off as invisible
        tryAgainScreen.setVisible(false);
    }
	/*
		Non-important Swing methods
	*/

    private JFrame createFrame() {
        JFrame frame = new JFrame("The Guessing Game!");
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 1));
        return frame;
    }

    private JLabel createMainLabel() {
        JLabel mainLabel = new JLabel();
        mainLabel.setText("Would you like to try again?");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainLabel.setHorizontalAlignment(JButton.CENTER);
        return mainLabel;
    }

    private JButton createNoButton(){
        return new JButton(new AbstractAction("No") {
            public void actionPerformed(ActionEvent e) {
                tryAgainValue = false;
                //Release the semaphore so that the game progresses
                MainSwing.available.release();
            }
        });
    }

    private JButton createYesButton(){
        return new JButton(new AbstractAction("Yes") {
            public void actionPerformed(ActionEvent e) {
                tryAgainValue = true;
                //Release the semaphore so that the game progresses
                MainSwing.available.release();
            }
        });
    }

    private JPanel createButtonPanel(){
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(1, 2));
        return midPanel;
    }
}
