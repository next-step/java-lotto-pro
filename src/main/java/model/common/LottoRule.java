package model.common;

import utility.Assert;

public final class LottoRule {

	private static final int MINIMUM_LIMIT = 1;

	private final Range range;
	private final int count;

	private LottoRule(Range range, int count) {
		Assert.notNull(range, "'range' must not be null");
		validate(range, count);
		this.range = range;
		this.count = count;
	}

	public static LottoRule of(Range range, int count) {
		return new LottoRule(range, count);
	}

	public int minNumber() {
		return range.min();
	}

	public int maxNumber() {
		return range.max();
	}

	public boolean differentCount(int count) {
		return count != this.count;
	}

	public int count() {
		return count;
	}

	public int[] numbers() {
		return range.numbers();
	}

	public boolean outOfRange(int target) {
		return range.isOut(target);
	}

	@Override
	public String toString() {
		return "LottoRule{" +
			"range=" + range +
			", count=" + count +
			'}';
	}

	private void validate(Range range, int count) {
		Assert.isTrue(count >= MINIMUM_LIMIT,
			String.format("count(%d) must be greater than %d", count, MINIMUM_LIMIT));

		Assert.isTrue(range.lessThanSize(count),
			String.format("gap between minValue(%d) and maxValue(%d) must be more than count(%d)",
				range.min(), range.max(), count));
	}
}
