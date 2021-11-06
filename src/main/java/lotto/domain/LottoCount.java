package lotto.domain;

public class LottoCount {
	private final int count;

	private LottoCount(int count) {
		this.count = count;
	}

	public static LottoCount of(int count) {
		return new LottoCount(count);
	}

	public static LottoCount minus(LottoCount first, LottoCount second) {
		return LottoCount.of(first.getValue() - second.getValue());
	}

	public int getValue() {
		return count;
	}
}
