import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class AudioTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String response = "";
		
		try {
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("Giorno.wav"));
			
			try {
				
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				while (!response.equals("q")) {
					System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
					System.out.println("Enter your choice:");
					
					response = scanner.next();
					response = response.toLowerCase();
					
					switch (response) {
					
					case ("p"): clip.start();
					break;
					
					case ("s"): clip.stop();
					break;
					
					case ("r"): clip.setMicrosecondPosition(0);
					break;
					
					case ("q"): clip.close();
					scanner.close();
					clip.close();
					break;
					
					default: System.out.println("Not a valid key");
					break;
					
					}
				}
				
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}
			
		} catch (UnsupportedAudioFileException | IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("Thanks for using BASS! :)");
		
	}

}
