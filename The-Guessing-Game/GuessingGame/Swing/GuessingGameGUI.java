/*
GuessingGameGUI class.
Class that holds the Swing window information for the main screen of the Guessing Game
*/
package GuessingGame.Swing;
import GuessingGame.core.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GuessingGameGUI {

    /*
		Member variables
	*/
    /* Configuration file. Stores allowed attempts data and highest possible guess bound. */
    private Configuration config;
    /* SoundsGUI file that sounds the clips for winning, losing, and wrong guesses */
    private SoundsGUI sounds;
    /* Window that holds the information for the main Guessing Game screen */
    private JFrame mainScreen;
    /* JButton for the user to confirm their guess */
    private JButton submit;
    /* JLabel that presents feedback about the last guess to the user */
    private JLabel feedback;
    /* JLabel that presents the current guess to the user */
    private JLabel theirGuess;
    /* Keeps the data that is within the JLabel that is theirGuess */
    private String value;
    /* Keeps the data that will be sent as the guess */
    private int guess;

    /*
		Member methods:
		    Important methods
	*/
    /* Method that returns the value of the currently made guess */
    public int returnGuess() { return guess; }
    /* Method that returns the information of the mainScreen window */
    public JFrame returnMainscreen() { return mainScreen; }
    /* Use this method to SHOW the main screen */
    public void turnOnMainAgainScreen() {mainScreen.setVisible(true);}
    /* Use this method to HIDE the main screen */
    public void turnOffMainAgainScreen() {mainScreen.setVisible(false);}
    /* Method that plays a clip to indicate an incorrect guess */
    public void playError() { sounds.PlayErrorSound(); }
    /* Method that plays a clip to indicate that the player has won */
    public void playWin() { sounds.PlayWinSound(); }
    /* Method that plays a clip to indicate that the player has lost */
    public void playLose() { sounds.PlayLoseSound(); }
    /* User feedback that informs the player of a high guess */
    public void setFeedbackHigh() {
        feedback.setText("Your last guess of " + guess + " was too high!");
    }
    /* User feedback that informs the player of a low guess */
    public void setFeedbackLow() {
        feedback.setText("Your last guess of " + guess + " was too low!");
    }
    /* User feedback that informs the player that they've won the game */
    public void setFeedbackWon() {
        //Disable the button if the game is over
        submit.setEnabled(false);
        feedback.setText("Congratulations! You've won!");
    }
    /* User feedback that informs the player of a gameover */
    public void setFeedbackLost() {
        //Disable the button if the game is over
        submit.setEnabled(false);
        feedback.setText("Oh no! You've lost!");
    }
    /* Main constructor; requires a Configuration file */
    public GuessingGameGUI(Configuration config) {
        this.config = config;
        sounds = new SoundsGUI();
        //Since I use charAt() on value, it's a good idea to initialize it.
        value = "0";
        CreateAndAddComponents();
    }
    /* Method used to create the Swing components */
    private void CreateAndAddComponents() {
        //Create the components
        mainScreen = createFrame();
        submit = createSubmit();
        feedback = createFeedback();
        JPanel choices = createChoices();
        JLabel mainLabel = createMainLabel();
        JLabel instructions = createInstructions();
        //Create panels that'll hold the components
        JPanel bottomPanel = createPanel();
        JPanel middlePanel = createPanel();
        JPanel upperPanel = createPanel();
        //Add the feedback label and submit button in the bottom
        //instructions in the middle, and the main label on top
        bottomPanel.add(feedback);
        bottomPanel.add(submit);
        middlePanel.add(instructions);
        upperPanel.add(mainLabel);
        //Add the panels to the main window
        mainScreen.add(upperPanel);
        mainScreen.add(middlePanel);
        mainScreen.add(choices);
        mainScreen.add(bottomPanel);
        //This window starts as visible
        mainScreen.setVisible(true);
    }

    /*
    Swing methods:
		Important Swing methods
	*/
    private JPanel createChoices() {
        //Instantiate the label that displays their current option.
        theirGuess = new JLabel(value);
        //Make a new panel using a GridBag Layout.
        JPanel pane = new JPanel(new GridBagLayout());
        //Create new constraints for GridBag
        GridBagConstraints c = new GridBagConstraints();
        //Specify that the extra space will be distributed both horizontally and vertically
        c.fill = GridBagConstraints.BOTH;
        //Create array of JButtons and instantiate them
        JButton[] numberButtons = new JButton[11];
        //i: index for buttons, j: x coordinate for GridBag, k: y coordinate for GridBag
        for (int i = 1, j = 0, k = 0; i < 10; i++, j++){
            //i starts off as 1, and i%3 == 1, so we go into the if-statement.
            if (i % 3 == 1) {
                j = 0;
                k++;
            }
            //Need to declare a final in order to call it from within an inner class.
            final int z = i;
            //Establish the x and y coordinates using j and k, respectively.
            c.gridx = j;
            c.gridy = k;
            //Instantiate each button from 1 through 9
            numberButtons[i] = new JButton(new AbstractAction(Integer.toString(i)) {
                @Override
                public void actionPerformed(ActionEvent e) { setTargetText(z); }});
            //Add each button to the GridBag using the GridBag constraints
            pane.add(numberButtons[i], c);
        }
        //Instantiate the "0" button.
        numberButtons[0] = new JButton(new AbstractAction("0") {
            @Override
            public void actionPerformed(ActionEvent e) { setTargetText(0); }});
        //Establish the x and y coordinates by hardcoding them.
        c.gridx = 2;
        c.gridy = 0;
        //Add the "0" button to the GridBag using the GridBag constraints.
        pane.add(numberButtons[0], c);
        //Instantiate the "Clear" button.
        numberButtons[10] = new JButton(new AbstractAction("Clear") {
            @Override
            public void actionPerformed(ActionEvent e) { setTargetText(0); }});
        //Establish the x and y coordinates by hardcoding them.
        c.gridx = 0;
        c.gridy = 0;
        //Declare that the width of this button will be twice the others.
        c.gridwidth = 2;
        //Specify how the extra space of this button will be layed out.
        c.fill = GridBagConstraints.HORIZONTAL;
        //Add the "Clear" button to the GridBag using the GridBag constraints.
        pane.add(numberButtons[10], c);
        //Establish the x and y coordinates for the theirGuess JLabel by hardcoding them.
        c.gridx = 2;
        c.gridy = 4;
        //Declare that the width of this button will be thrice the others.
        c.gridwidth = 3;
        //Specify how the extra space of this button will be layed out.
        c.fill = GridBagConstraints.HORIZONTAL;
        //Add the theirGuess JLabel to the GridBag using the GridBag constraints.
        pane.add(theirGuess, c);
        return pane;
    }

    private void setTargetText(int number) {
        Integer bound = new Integer(config.getMaxNumber());
        //Append the argument to the end of value, which holds the current guess in a String
        value += Integer.toString(number);
        //Check the numerical representation of value (safe parse because only I write to it)
        //If true: value is now the single digit that was passed as an argument
        if (Integer.parseInt(value) > bound.intValue()){ value = "0" + Integer.toString(number); }
        //Check if the current length (after adding) is larger than 2.
        //If true: take the LAST two numubers of value
        if (value.length() > bound.toString().length() ) { value = value.substring( (value.length() - (bound.toString().length()) ) ); }
        //Set the text of the theirGuess JLabel as value
        theirGuess.setText(value);
    }

    /*
		Non-important Swing methods
	*/
    private JFrame createFrame() {
        JFrame frame = new JFrame("The Guessing Game!");
        frame.setMinimumSize(new Dimension(600, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout( new BoxLayout( frame.getContentPane(), BoxLayout.Y_AXIS) );
        return frame;
    }

    private JButton createSubmit(){
        return new JButton(new AbstractAction("Submit") {
            public void actionPerformed(ActionEvent e) {
                guess = Integer.parseInt( theirGuess.getText() );
                //Release the semaphore so that the game progresses
                MainSwing.available.release();
            }
        });
    }

    private JLabel createMainLabel() {
        JLabel mainLabel = new JLabel();
        mainLabel.setText("Welcome to the Guessing Game!");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 22));
        return mainLabel;
    }

    private JLabel createInstructions() {
        JLabel instructions = new JLabel();
        instructions.setText("Please enter a guess from 0 to " + config.getMaxNumber());
        instructions.setFont(new Font("Arial", Font.PLAIN, 16));
        return instructions;
    }

    private JLabel createFeedback() {
        JLabel feedback = new JLabel();
        feedback.setFont(new Font("Arial", Font.PLAIN, 12));
        return feedback;
    }

    private JPanel createPanel() { return new JPanel(); }
}