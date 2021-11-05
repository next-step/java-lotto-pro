package calculator;

public class Input {

	private final String input;

	public Input(final String text) {
		input = text;
	}

	public boolean isNullOrEmpty() {
		return input == null || input.isEmpty();
	}

	public String[] values() {
		return Separator.split(input);
	}
}
