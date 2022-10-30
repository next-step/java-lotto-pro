package lotto.domain;

import java.util.Arrays;

import money.Money;

public enum LottoWinPrize {
	MISS_EIGHTH(0, Money.ZERO, false),
	MISS_SEVENTH(1, Money.ZERO, false),
	MISS_SIXTH(2, Money.ZERO, false),
	FIFTH(3, Money.wons(5_000), false),
	FOURTH(4, Money.wons(5_000), false),
	THIRD(5, Money.wons(1_500_000), false),
	SECOND(5, Money.wons(30_000_000), true),
	FIRST(6, Money.wons(2_000_000_000), false);

	public final int matchCount;
	public final Money prize;
	public final boolean hasBonusBall;

	LottoWinPrize(int matchCount, Money prize, boolean hasBonusBall) {
		this.matchCount = matchCount;
		this.prize = prize;
		this.hasBonusBall = hasBonusBall;
	}

	public static LottoWinPrize matchCountOf(int matchCount) {
		return Arrays.stream(LottoWinPrize.values())
			.filter(winPrize -> winPrize.matchCount == matchCount)
			.findAny()
			.orElseThrow(IllegalArgumentException::new);
	}
}
