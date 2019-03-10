package hangmangame.output;

public interface GraphicsEngine {
	
	public void displayWelcome();
	
	public void displayWordInput();

	public void displayWord(final String displayedWord, final int tryNumber);
	
	public void displayWin();
	
	public void displayLoss();
	
	public void displayRetry();
}
