package calculator;

import calculator.wrapper.CalculatorParser;

public class StringCalculator {
	private String delimiter;
	private String input;

	public StringCalculator(String input) {
		CalculatorParser parser = new CalculatorParser(input);
		this.delimiter = parser.getDelimiter();
		this.input = parser.getInput();

	}

	public int calculate() {
		String[] chunkedList = this.input.split(this.delimiter);
		int calculated = 0;
		try {
			calculated = sum(chunkedList);
		} catch (Exception e) {
			throw new RuntimeException("The input is not valid");
		}
		return calculated;
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for (String num : numbers) {
			sum += validNumber(num);
		}
		return sum;
	}

	private int validNumber(String num) {
		int i = num.isEmpty() ? 0 : Integer.parseInt(num);
		if (i < 0) {
			throw new RuntimeException();
		}
		return i;
	}
}
