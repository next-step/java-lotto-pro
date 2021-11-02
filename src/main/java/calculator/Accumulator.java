package calculator;

import java.util.Collection;

public class Accumulator {

	public static int accumulate(Collection<Integer> numbers) {
		int result = 0;
		for (Integer number : numbers) {
			result += number;
		}
		return result;
	}

}
