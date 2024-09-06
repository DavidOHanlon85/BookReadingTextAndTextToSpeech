package challengeBookReadingTextAndTextToSpeech;

public class DisplayTextLineByLine implements Runnable {

	private boolean stopRead = false;

	@Override
	public void run() {

		readToScreen();

	}

	/**
	 * This method reads the book, line by line to screen.
	 */
	public void readToScreen() {
		while (!StarterApp.wholeText.isEmpty()) {

			System.out.println(StarterApp.wholeText.remove());

			if (stopRead == true) {

				System.out.println("Stopping the read to screen");
				return;

			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * @param stopRead the stopRead to set
	 */
	public void setStopRead(boolean stopRead) {
		this.stopRead = stopRead;
	}

}
