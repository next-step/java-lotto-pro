package lotto.domain;

public class CustomLottoCount {
	private final int count;

	private CustomLottoCount(int count) {
		this.count = count;
	}

	public static CustomLottoCount of(int count) {
		return new CustomLottoCount(count);
	}

	public int getValue() {
		return count;
	}
}
