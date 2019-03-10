package hangmangame.controller;

import java.util.List;

import hangmangame.input.console.SimpleConsoleReader;
import hangmangame.output.GraphicsEngine;
import hangmangame.output.console.SimpleConsoleEngine;

public class Controller {

	private static final int MAX_TRIES = 10;

	private SimpleConsoleReader inputReader = new SimpleConsoleReader();
	private GraphicsEngine graphicsEngine = new SimpleConsoleEngine();
	private SolutionWord solutionWord;
	private DisplayedWord displayedWord;

	private boolean won;

	public void run() {
		boolean retry = true;
		
		while (retry) {
			won = false;

			graphicsEngine.displayWelcome();
			graphicsEngine.displayWordInput();
			solutionWord = new SolutionWord(inputReader.readWord());
			displayedWord = new DisplayedWord(solutionWord.getLength());

			won = makeGuess();
			
			if(won) {
				graphicsEngine.displayWin();
			} else {
				graphicsEngine.displayLoss();
			}
			
			graphicsEngine.displayRetry();
			retry = inputReader.readRetry();
		}
	}

	private boolean makeGuess() {
		int tries = 0;
		graphicsEngine.displayWord(displayedWord.get(), tries);
		
		while (tries < MAX_TRIES && !won) {
			final String guess = inputReader.readWord();

			if (guess.length() > 1) {
				won = isSolutionWord(guess);
			} else if (containsCorrectCharacter(guess)) {
				won = isSolved();
			}

			graphicsEngine.displayWord(displayedWord.get(), tries);

			tries++;
		}
		return won;
	}

	private boolean isSolutionWord(final String guess) {
		if (solutionWord.equals(guess)) {
			displayedWord.set(solutionWord.get());

			return true;
		}

		return false;
	}

	private boolean containsCorrectCharacter(final String guess) {
		if (guess.length() == 1 && solutionWord.contains(guess.substring(0, 1))) {
			final List<Integer> indexes = solutionWord.getIndexesOf(guess.substring(0, 1));
			displayedWord.update(guess.substring(0, 1), indexes);

			return true;
		}

		return false;
	}

	private boolean isSolved() {
		if (solutionWord.equals(displayedWord)) {
			return true;
		}

		return false;
	}

}
