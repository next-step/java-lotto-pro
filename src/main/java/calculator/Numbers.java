package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {

	private final List<Number> numbers;

	public Numbers(String[] inputNumbers) {
		this.numbers = new ArrayList<>();
		for (String inputNumber : inputNumbers) {
			numbers.add(new Number(inputNumber));
		}
	}

	public int sum() {
		int sum = 0;
		for (Number number : this.numbers) {
			sum += number.getNumber();
		}
		return sum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Numbers numbers1 = (Numbers)o;
		return Objects.equals(numbers, numbers1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
