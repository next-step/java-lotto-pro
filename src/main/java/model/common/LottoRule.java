package model.common;

import utility.Assert;

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

	public boolean outOfRange(int target) {
		return lessThanMinValue(target) || moreThanMaxValue(target);
	}

	@Override
	public String toString() {
		return "LottoRule{" +
			"minNumber=" + minNumber +
			", maxNumber=" + maxNumber +
			", count=" + count +
			'}';
	}

	private boolean moreThanMaxValue(int target) {
		return maxNumber < target;
	}

	private boolean lessThanMinValue(int target) {
		return target < minNumber;
	}

	private void validate(int minNumber, int maxNumber, int count) {
		Assert.isTrue(positive(minNumber), "'minNumber' must be positive");
		Assert.isTrue(moreThanMinLimit(count),
			String.format("count(%d) must be greater than %d", count, MINIMUM_LIMIT));
		Assert.isTrue(moreThan(gap(maxNumber, minNumber), count),
			String.format("gap between minValue(%d) and maxValue(%d) must be more than count(%d)", minNumber, maxNumber,
				count));
	}

	private boolean moreThanMinLimit(int count) {
		return moreThan(count, MINIMUM_LIMIT);
	}

	private int gap(int maxNumber, int minNumber) {
		return maxNumber - minNumber + 1;
	}

	private boolean positive(int value) {
		return moreThan(value, 0);
	}

	private boolean moreThan(int value, int target) {
		return value >= target;
	}
}
