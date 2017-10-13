package GuessingGame.JFX;

import GuessingGame.core.Configuration;

public class ClientFX {
    public static void main(String[] args) {
        try {
            System.out.println("Entered");
            GuessingGameGUI guessinggame = new GuessingGameGUI();
            System.out.println("Exited");
        } catch (Exception ignored) {}
    }
}
