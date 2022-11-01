package lotto.domain.yield;

import java.util.Objects;

public class Yield {
	public static final float YIELD_MIN_RANGE = 0f;
	private final float yield;

	private Yield(float yield) {
		this.yield = yield;
	}

	public static Yield from(float yield) {
		validateRange(yield);
		return new Yield(yield);
	}

	private static void validateRange(float yield) {
		if (yield < YIELD_MIN_RANGE) {
			throw new IllegalArgumentException("수익률은 0% 미만일 수 없습니다.");
		}
	}

	public boolean isGreaterThan(Yield o) {
		return this.yield > o.yield;
	}

	public float getFloat() {
		return yield;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Yield yield1 = (Yield)o;
		return Float.compare(yield1.yield, yield) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(yield);
	}
}
