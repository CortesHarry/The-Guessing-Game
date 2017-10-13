package GuessingGame.JFX;

import GuessingGame.core.Configuration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class GuessingGameGUI extends Application {

    SuppMethodsFX supplimentarymethods;
    Scene guessinggame;
    Scene tryagainscreen;
    Button submit;
    Label feedback;
    static Configuration config;
    static String value = "00";
    static Label theirGuess;
    static int guess = 0;

    /*
    Since GuessingGameGUI extends Application I NEED to use the default constructor
    Whatever class is extending Application needs a default constructor
    Since my constructor needed arguments to be passed in, instead I will create and store them here
     */
    public GuessingGameGUI()  {
        try {Configuration config = new Configuration(16, 4);}
        catch (Exception ignored) {}
        theirGuess = new Label(value);
        VarInitializer();
        launch();
    }

    public void VarInitializer() {
        submit = supplimentarymethods.createSubmitButton();
        feedback = supplimentarymethods.createFeedbackLabel();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        guessinggame = supplimentarymethods.CreateGuessingGameScene();
        primaryStage.setTitle("The Guessing Game! ");
        primaryStage.setMinWidth(50);
        primaryStage.setScene(guessinggame);
        primaryStage.show();
    }

    public static void submitGuess() {
        guess = Integer.parseInt(theirGuess.getText());
        //MainFX.available.release();
    }

    public static int getConfigAllowedGuesses() { return config.getAllowedGuesses(); }

    public static int getConfigMaxNumber() { return config.getMaxNumber(); }
}
