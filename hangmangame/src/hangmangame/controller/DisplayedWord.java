package hangmangame.controller;

import java.util.List;

public class DisplayedWord {
	private String displayedWord;

	public DisplayedWord (final int wordLength) {
		initializeDisplayedWord(wordLength);
	}
	
	private void initializeDisplayedWord(final int wordLength) {
		displayedWord = "";
		for (int i = 0; i < wordLength; i++) {
			displayedWord += "_";
		}
	}
	
	public void update(final String guess, List<Integer> indexes) {
		for(int index : indexes) {
			replaceDisplayedCharacterAt(index, guess);
		}
	}
	
	private void replaceDisplayedCharacterAt(int index, String guess) {
		if (index == 0) {
			guess = guess.toUpperCase();
		}
		
		final String prefix = displayedWord.substring(0, index);
		final String suffix = displayedWord.substring(index + 1);

		displayedWord = prefix + guess + suffix;

	}

	public String get() {
		return displayedWord;
	}

	public void set(String displayedWord) {
		this.displayedWord = displayedWord;
	}

}
