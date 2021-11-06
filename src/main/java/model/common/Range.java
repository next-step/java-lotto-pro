package model.common;

import utility.Assert;

public final class Range {

	private final int min;
	private final int max;

	private Range(int min, int max) {
		Assert.isTrue(positive(min), String.format("'min'(%d) must be positive", min));
		Assert.isTrue(max >= min, String.format("max(%d) must greater than min(%s)", max, min));
		this.min = min;
		this.max = max;
	}

	public static Range of(int min, int max) {
		return new Range(min, max);
	}

	boolean isOut(int number) {
		return isLessThanMin(number) || isOverThanMax(number);
	}

	int min() {
		return min;
	}

	int max() {
		return max;
	}

	int[] numbers() {
		int[] ints = new int[max - min + 1];
		int index = 0;
		for (int value = min; value <= max; value++) {
			ints[index++] = value;
		}
		return ints;
	}

	boolean lessThanSize(int count) {
		return count < size();
	}

	private int size() {
		return max - min + 1;
	}

	private boolean positive(int value) {
		return value > 0;
	}

	private boolean isOverThanMax(int number) {
		return max < number;
	}

	private boolean isLessThanMin(int number) {
		return number < min;
	}
}
