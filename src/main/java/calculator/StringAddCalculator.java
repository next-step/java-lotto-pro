package calculator;

import java.util.List;

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
		List<Integer> numbers = parser.parse(input);
		validateNumbers(numbers);
		return accumulator.accumulate(numbers);
	}

	private void validateNumbers(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (number < 0) {
				throw new RuntimeException("음수는 입력하실 수 없습니다");
			}
		}
	}

}
