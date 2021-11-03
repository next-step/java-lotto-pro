import wrapper.CalculatorParser;

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
		int sum = 0;
		try {
			sum = sum(chunkedList);
		} catch (Exception e) {
			throw new RuntimeException("The input is not valid");
		}
		return sum;
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for (String num : numbers) {
			int i = num.isEmpty() ? 0 : Integer.parseInt(num);
			if (i < 0) {
				throw new RuntimeException();
			}
			sum += i;
		}
		return sum;
	}
}
