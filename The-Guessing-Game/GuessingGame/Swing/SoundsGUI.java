/*
SoundsGUI class.
Class that holds the sounds data that'll be played throughout the game.
*/
package GuessingGame.Swing;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.io.File;

public class SoundsGUI {

    /*
		Member variables
	*/
    /* String directory to the audio file containing the error sound */
    private final String errorFile = "C:\\Users\\mexic\\Documents\\Programming\\GuessingGame\\GuessingGame\\Swing\\Sounds\\Error.wav";
    /* String directory to the audio file containing the winning sound */
    private final String winFile = "C:\\Users\\mexic\\Documents\\Programming\\GuessingGame\\GuessingGame\\Swing\\Sounds\\Win.wav";
    /* String directory to the audio file containing the losing sound */
    private final String lostFile = "C:\\Users\\mexic\\Documents\\Programming\\GuessingGame\\GuessingGame\\Swing\\Sounds\\Gameover.wav";
    /* Clip objects that'll hold the sounds for playing */
    private Clip winclip, lostclip, errorclip;

    /*
		Member methods:
		    Important methods
	*/
    /* Method to call if you want to play the error sound */
    public void PlayErrorSound(){
        errorclip.start();
        errorclip.setFramePosition(0);
    }
    /* Method to call if you want to play the gameover sound */
    public void PlayLoseSound(){ lostclip.start(); }
    /* Method to call if you want to play the winning sound */
    public void PlayWinSound(){ winclip.start(); }
    /* Default and main Constructor */
    public SoundsGUI() {
        CreateErrorClip();
        CreateLoseClip();
        CreateWinClip();
    }

    /*
		Non-important Clip object instantiating methods
	*/
    private void CreateErrorClip() {
        try{
            File file = new File(errorFile);
            DataLine.Info info = new DataLine.Info(Clip.class, AudioSystem.getAudioInputStream(file).getFormat());
            errorclip = (Clip) AudioSystem.getLine(info);
            errorclip.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e) {
            System.out.println("Critical error with the error sound!");
            System.out.println(e.getMessage());
        }
    }

    private void CreateWinClip() {
        try{
            File file = new File(winFile);
            DataLine.Info info = new DataLine.Info(Clip.class, AudioSystem.getAudioInputStream(file).getFormat());
            winclip = (Clip) AudioSystem.getLine(info);
            winclip.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e) {
            System.out.println("Critical error with the error sound!");
            System.out.println(e.getMessage());
        }
    }

    private void CreateLoseClip() {
        try{
            File file = new File(lostFile);
            DataLine.Info info = new DataLine.Info(Clip.class, AudioSystem.getAudioInputStream(file).getFormat());
            lostclip = (Clip) AudioSystem.getLine(info);
            lostclip.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e) {
            System.out.println("Critical error with the error sound!");
            System.out.println(e.getMessage());
        }
    }
}
