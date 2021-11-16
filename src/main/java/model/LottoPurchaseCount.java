package model;

import java.util.Objects;

import exception.OutOfRangeException;

public class LottoPurchaseCount {
	public static final String MESSAGE_COUNT_MUST_BE_LARGER_THAN_ZERO = "COUNT_MUST_BE_LARGER_THAN_ZERO";

	private final int purchaseCount;

	public LottoPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public int get() {
		return purchaseCount;
	}

	public boolean isLessThan(int other) {
		return this.purchaseCount < other;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoPurchaseCount that = (LottoPurchaseCount)o;
		return purchaseCount == that.purchaseCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(purchaseCount);
	}
}
