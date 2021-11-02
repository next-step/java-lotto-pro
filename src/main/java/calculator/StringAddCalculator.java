package calculator;

public class StringAddCalculator {

	private final Parser parser;
	private final Accumulator accumulator;

	public StringAddCalculator(Parser parser, Accumulator accumulator) {
		this.parser = parser;
		this.accumulator = accumulator;
	}

	public int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		Numbers numbers = parser.parse(input);
		return accumulator.accumulate(numbers);
	}

}
