import java.util.ArrayList;
import java.util.List;

public class Numbers {
	private final List<Number> numbers;

	public Numbers(List<Number> numbers) {
		this.numbers = numbers;
	}

	public Numbers(String[] strNumbers) {
		List<Number> numbers = new ArrayList<>();
		for (String number : strNumbers) {
			numbers.add(new Number(number));
		}
		this.numbers = numbers;
	}

	public Number summarize() {
		Number sum = new Number();
		for (Number number : numbers) {
			sum = sum.add(number);
		}
		return sum;
	}
}
