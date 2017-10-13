/*
MainFX class
Class that contains the main() method for the JFX package.
*/
package GuessingGame.JFX;
import GuessingGame.core.*;
import java.util.concurrent.Semaphore;

public class MainFX {

    /*
        Member variables
    */
    /* Semaphore that'll be used in the JFX package to pause the game to wait for user input */
    public static final Semaphore available = new Semaphore(0);

    /*
        Main method
    */
    /* Creates all the necessary files for a Game file to be made and played.
    public static void main(String[] args) throws Exception {
        boolean continues = true;
        do {
            //Construct a configuration file
            Configuration myConfig = new Configuration(16, 4);
            //Construct the Swing GUIs which are also client controllers and communicators

            //Construct the logic of the game
            ClientLogic logic = new GameLogic(myConfig);
            //Construct a Game object
            Game myGame = new Game();
            //Run the game
            myGame.play();
            //Determine if the user would like to play again
            continues;
            //If the user chooses no, then quit the program.
            if (!continues) { System.exit(0); }
        } while (continues);
    } */
}




/*

public class GuessingGameGUI extends Application {

    Configuration config;
    String[] args = new String[]{"0"};

    public GuessingGameGUI() { try{config = new Configuration(16, 4);}catch(Exception e) {} }

    public GuessingGameGUI(Configuration config) {
        System.out.println("Constructor");
        this.config = config;
        System.out.println(" now in launch() ");
        System.out.println(" now in launch() ");
        try {
            launch(args);
        } catch ( Exception e) {System.out.println(e.getMessage()); }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CreateAndAddComponents(primaryStage);
    }

    private void CreateAndAddComponents(Stage window) throws Exception {
        window.setTitle("The Guessing Game! ");
        window.setMinWidth(350);
        window.showAndWait();
    }
}

*/









