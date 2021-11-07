package step2.domain;

public class NumberElement {
	private int number;

	public NumberElement(int number) {
		validate(number);
		this.number = number;
	}

	public static NumberElement of(String str) {
		int toNumber;
		try {
			toNumber = Integer.parseInt(str);
		} catch (Exception e) {
			throw new RuntimeException(String.format("[ERROR] text is not Integer format. text = %s", str));
		}
		validate(toNumber);
		return new NumberElement(toNumber);
	}

	public int getNumber() {
		return this.number;
	}

	public static void validate(int number) {
		if (number <= 0) {
			throw new RuntimeException(String.format("[ERROR] Number is negative. number = %d", number));
		}
	}
}
