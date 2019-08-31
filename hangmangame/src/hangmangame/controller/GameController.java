package hangmangame.controller;

import hangmangame.input.console.SimpleConsoleReader;
import hangmangame.output.GraphicsEngine;
import hangmangame.output.console.SimpleConsoleEngine;

import java.util.List;

public class GameController {

    private static final int MAX_TRIES = 10;

    private SimpleConsoleReader inputReader = new SimpleConsoleReader();
    private GraphicsEngine graphicsEngine = new SimpleConsoleEngine();
    private SolutionWord solutionWord;
    private DisplayedWord displayedWord;

    private boolean hasWon;

    public void startGame() {
        boolean retry = true;

        while (retry) {
            hasWon = false;

            graphicsEngine.displayWelcome();
            graphicsEngine.displayWordInput();
            solutionWord = new SolutionWord(inputReader.readWord());
            displayedWord = new DisplayedWord(solutionWord.getLength());

            startRound();

            if (hasWon) {
                graphicsEngine.displayWin();
            } else {
                graphicsEngine.displayLoss();
            }

            graphicsEngine.displayRetry();
            retry = inputReader.readRetry();
        }
    }

    private void startRound() {
        int tries = 0;
        graphicsEngine.displayWord(displayedWord.get(), tries);

        while (tries < MAX_TRIES && !hasWon) {
            makeGuess();

            hasWon = solutionWord.equals(displayedWord);
            graphicsEngine.displayWord(displayedWord.get(), tries);

            tries++;
        }
    }

    private void makeGuess() {
        final String guess = inputReader.readWord();

        if (isWord(guess) && solutionWord.equals(guess)) {
			displayedWord.set(solutionWord.get());
        } else if (isLetter(guess) && solutionWord.contains(guess)) {
            final List<Integer> indexes = solutionWord.getIndexesOf(guess);
            displayedWord.update(guess, indexes);
		}
	}

    private boolean isWord(String guess) {
        return guess.length() > 1;
    }

    private boolean isLetter(String guess) {
        return guess.length() == 1;
    }

}
