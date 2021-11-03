package calculator;

import java.util.Arrays;

public class Calculator {

	private StringInput input;

	public Calculator(String input) {
		this.input = new StringInput(input);
	}

	public int getSum() {
		return sum(input.separate());
	}

	private int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
	}

}
