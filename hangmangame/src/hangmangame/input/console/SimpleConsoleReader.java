package hangmangame.input.console;

import java.util.Scanner;

import hangmangame.input.InputReader;

public class SimpleConsoleReader implements InputReader {
	final Scanner scanner = new Scanner(System.in);

	@Override
	public String readWord() {
		return scanner.next();
	}

	@Override
	public boolean readRetry() {
		final String retry = scanner.next();
		if (retry.equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public void close() {
		scanner.close();
	}

}
