import java.util.ArrayList;
import java.util.List;

public class CalculatorNumbers {
	private final List<CalculatorNumber> values;

	public CalculatorNumbers(List<Integer> values) {
		this.values = new ArrayList<>();
		for (int value : values) {
			this.values.add(new CalculatorNumber(value));
		}
	}

	public boolean containExceptional() {
		return this.values.stream().anyMatch(CalculatorNumber::isExceptional);
	}

	public boolean hasSingleNumber() {
		return this.values.size() == 1;
	}
}