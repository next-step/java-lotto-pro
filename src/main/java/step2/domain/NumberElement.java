package step2.domain;

public class NumberElement {
	private final int number;

	public NumberElement(int number) {
		validate(number);
		this.number = number;
	}

	public static NumberElement of(String strElement) {
		return new NumberElement(convertToNumber(strElement));
	}

	public int getNumber() {
		return this.number;
	}

	private static int convertToNumber(String strElement) {
		try {
			return Integer.parseInt(strElement);
		} catch (Exception e) {
			throw new RuntimeException(
				String.format("[ERROR] strElement is not Integer format. strElement = %s", strElement));
		}
	}

	public static void validate(int number) {
		if (number <= 0) {
			throw new RuntimeException(String.format("[ERROR] Number is negative. number = %d", number));
		}
	}
}
