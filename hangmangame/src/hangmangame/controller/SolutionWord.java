package hangmangame.controller;

import java.util.ArrayList;
import java.util.List;

public class SolutionWord {
	private final String solutionWord;

	public SolutionWord(final String solutionWord) {
		this.solutionWord = solutionWord;
	}

	public boolean contains(final String guess) {
		String solutionWordLC = solutionWord.toLowerCase();
		
		return solutionWordLC.contains(guess.toLowerCase());
	}

	public List<Integer> getIndexesOf(final String guess) {
		final List<Integer> indexes = new ArrayList<>();
		final String guessLC = guess.toLowerCase();
		String solutionWordLC = this.solutionWord.toLowerCase();

		int offset = 0;
		while (solutionWordLC.contains(guessLC)) {
			final int index = solutionWordLC.indexOf(guessLC);
			indexes.add(offset + index);
			offset = offset + index + 1;
			solutionWordLC = solutionWordLC.substring(index + 1);
		}

		return indexes;
	}
	
	public int getLength() {
		return solutionWord.length();
	}
 	
	public boolean equals(DisplayedWord displayedWord) {
		return this.solutionWord.equals(displayedWord.get());
	}
	
	public boolean equals(String guess) {
		return this.solutionWord.toLowerCase().equals(guess.toLowerCase());
	}
	
	public String get() {
		return this.solutionWord;
	}
}
