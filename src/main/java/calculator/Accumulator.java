package calculator;

public class Accumulator {

	public int accumulate(Numbers numbers) {
		int result = 0;
		for (Integer number : numbers) {
			result += number;
		}
		return result;
	}

}
