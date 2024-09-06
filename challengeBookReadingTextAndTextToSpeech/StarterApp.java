/**
 * 
 */
package challengeBookReadingTextAndTextToSpeech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class StarterApp {

	public static Queue<String> wholeText = new LinkedList<String>();
	public static DisplayTextLineByLine displayText = new DisplayTextLineByLine();

	public static void main(String[] args) {

		System.out.println("Welcome to QUB Book Read");

		Scanner sc = new Scanner(System.in);
		int input = 0;

		do {

			System.out.println("1. Load book");
			System.out.println("2. Read/ Resume Book");
			System.out.println("3. Pause Book");
			System.out.println("4. Quit");

			System.out.println("Enter option");
			input = sc.nextInt();

			switch (input) {
			case 1:
				readInBook();
				break;
			case 2:
				beginResumeRead();
				break;
			case 3:
				stopRead();
				break;
			case 4:
				exitSystem();
				break;
			default:
				invalidInput();
			}

		} while (input != 4);

	}

	/**
	 * This method exits with an invalid input
	 */
	public static void invalidInput() {
		System.out.println("Invalid Input - Please try again");
	}

	/**
	 * This method exits system with ending message
	 */
	public static void exitSystem() {
		displayText.setStopRead(true);
		System.out.println("Goodbye - Have a nice day");
	}

	/**
	 * This method stops the read
	 */
	public static void stopRead() {
		System.out.println("Going to stop the read");
		displayText.setStopRead(true);
	}

	/**
	 * This method begins or resumes the read thread - will start where it finished due to dequeuing 
	 */
	public static void beginResumeRead() {
		displayText.setStopRead(false);
		Thread t1 = new Thread(displayText);
		t1.start();
	}

	/**
	 * This method reads in the Dracula book line by line
	 */
	public static void readInBook() {
		File file = new File("Dracula-1.txt");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line;

			line = br.readLine();

			while (line != null) {

				wholeText.add(line);

				line = br.readLine();

			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
