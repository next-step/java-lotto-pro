package model;

public class LottoRule {

	private static final int MINIMUM_LIMIT = 1;

	private final int minNumber;
	private final int maxNumber;
	private final int count;

	private LottoRule(int minNumber, int maxNumber, int count) {
		validate(minNumber, maxNumber, count);
		this.maxNumber = maxNumber;
		this.minNumber = minNumber;
		this.count = count;
	}

	public static LottoRule of(int minNumber, int maxNumber, int count) {
		return new LottoRule(minNumber, maxNumber, count);
	}

	public int minNumber() {
		return minNumber;
	}

	public int maxNumber() {
		return maxNumber;
	}

	public boolean differentCount(int count) {
		return count != this.count;
	}

	public int count() {
		return count;
	}

	public int[] numbers() {
		int[] ints = new int[maxNumber - minNumber + 1];
		int index = 0;
		for (int value = minNumber; value <= maxNumber; value++) {
			ints[index++] = value;
		}
		return ints;
	}

	public boolean invalidNumber(int target) {
		return lessThanMinValue(target) || moreThanMaxValue(target);
	}

	private boolean moreThanMaxValue(int target) {
		return maxNumber < target;
	}

	private boolean lessThanMinValue(int target) {
		return target < minNumber;
	}

	private void validate(int minNumber, int maxNumber, int count) {
		validateMinNumber(minNumber);
		validateCount(count);
		validateGap(minNumber, maxNumber, count);
	}

	private void validateGap(int minNumber, int maxNumber, int count) {
		if (lessThan(availableNumbersCount(maxNumber, minNumber), count)) {
			throw new IllegalArgumentException(
				String.format("gap between minValue(%d) and maxValue(%d) must be more than count(%d)", minNumber,
					maxNumber, count));
		}
	}

	private int availableNumbersCount(int maxNumber, int minNumber) {
		return maxNumber - minNumber + 1;
	}

	private void validateMinNumber(int value) {
		if (negative(value)) {
			throw new IllegalArgumentException("'minNumber' must be positive");
		}
	}

	private boolean negative(int value) {
		return lessThan(value, 0);
	}

	private boolean lessThan(int value, int target) {
		return value < target;
	}

	private void validateCount(int count) {
		if (count < MINIMUM_LIMIT) {
			throw new IllegalArgumentException(
				String.format("count(%d) must be greater than %d", count, MINIMUM_LIMIT));
		}
	}

}
