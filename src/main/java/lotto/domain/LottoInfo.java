package lotto.domain;

public enum LottoInfo {

	MAX_LOTTO_NUMBER(45),
	MIN_LOTTO_NUMBER(1),
	MAX_LOTTO_NUMBER_SIZE(6),
	;

	private final int value;

	LottoInfo(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
