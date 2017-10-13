package GuessingGame.JFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SuppMethodsFX {

    public static Scene CreateGuessingGameScene() {
        VBox layout = new VBox(10);
        layout.getChildren().addAll(createMainLabel(), createInstructions(), createFeedbackLabel(), createSubmitButton());
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        return scene;
    }

    public static Button createSubmitButton() {
        Button submit = new Button("submit");
        submit.setOnAction(e -> GuessingGameGUI.submitGuess() );
        return submit;
    }

    public static Label createFeedbackLabel() {
        Label feedback = new Label("Try guessing!");
        feedback.setFont(new Font("Arial", 12));
        return feedback;
    }

    private static Label createInstructions() {
        Label instructions = new Label();
        instructions.setFont(new Font("Arial", 16));
        instructions.setText("Please enter a guess from 1 to " + GuessingGameGUI.getConfigMaxNumber());
        return instructions;
    }

    private static Label createMainLabel() {
        Label mainLabel = new Label();
        mainLabel.setFont(new Font("Arial", 22));
        mainLabel.setText("Welcome to the GuessingGame!");
        return mainLabel;
    }
}
