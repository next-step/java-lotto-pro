public class Number {
	private final int number;

	public Number(int number) {
		if (number < 0) {
			throw new RuntimeException("negative value is denied.");
		}
		this.number = number;
	}

	public Number(String number) {
		this(Integer.parseInt(number));
	}

	public Number() {
		this.number = 0;
	}

	public Number add(Number number) {
		return new Number(this.number + number.number);
	}

	public int getNumber() {
		return number;
	}
}
