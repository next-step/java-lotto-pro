public class CalculatorNumber {
	private final int value;

	public CalculatorNumber(int value) {
		this.value = value;
	}

	public boolean isExceptional() {
		return this.value < 0;
	}

	public int getValue() {
		return value;
	}
}
