package hangmangame.output.console;

import hangmangame.output.GraphicsEngine;

public class SimpleConsoleEngine implements GraphicsEngine {

	@Override
	public void displayWelcome() {
		System.out.println("Hello and welcome to this game of hangman!");
	}

	@Override
	public void displayWordInput() {
		System.out.println("Please enter a word to start: ");
	}

	@Override
	public void displayWord(String displayedWord, int tryNumber) {
		System.out.println(displayedWord);
	}
	
	@Override
	public void displayWin() {
		System.out.println("You won, congrats!");
	}

	@Override
	public void displayLoss() {
		System.out.println("Sorry, you lost.");
		
	}

	@Override
	public void displayRetry() {
		System.out.println("Retry? (Y/N)");
	}

}
