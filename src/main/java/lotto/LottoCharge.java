package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoCharge {
	private static final int LOTTO_PRICE = 1000;
	private final int value;

	private LottoCharge(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("구입금액은 0보다 커야합니다");
		}
		if (value % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException("구입금액은 1000의 배수여야 합니다");
		}
		this.value = value;
	}

	public static LottoCharge from(int value) {
		return new LottoCharge(value);
	}

	public static LottoCharge from(String value) {
		if (!isNumber(value)) {
			throw new IllegalArgumentException("양수만 입력 가능합니다");
		}
		return new LottoCharge(Integer.parseInt(value));
	}

	private static boolean isNumber(String value) {
		return value.chars()
				.allMatch(Character::isDigit);
	}

	public int count() {
		return value / LOTTO_PRICE;
	}

	public double revenueRate(double revenue) {
		return BigDecimal.valueOf(revenue / value)
				.setScale(2, RoundingMode.FLOOR)
				.doubleValue();
	}
}
