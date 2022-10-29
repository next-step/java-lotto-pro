package lotto.view;

import java.util.Arrays;

import money.Money;

public enum LottoWinPrize {
	MISS_EIGHTH(0, Money.ZERO),
	MISS_SEVENTH(1, Money.ZERO),
	MISS_SIXTH(2, Money.ZERO),
	FIFTH(3, Money.wons(5_000)),
	FOURTH(4, Money.wons(5_000)),
	THIRD(5, Money.wons(1_500_000)),
	SECOND(5, Money.wons(30_000_000)),
	FIRST(6, Money.wons(2_000_000_000));

	public final int matchCount;
	public final Money prize;

	LottoWinPrize(int matchCount, Money prize) {
		this.matchCount = matchCount;
		this.prize = prize;
	}

	public static LottoWinPrize matchCountOf(int matchCount) {
		return Arrays.stream(LottoWinPrize.values())
			.filter(winPrize -> winPrize.matchCount == matchCount)
			.findAny()
			.orElseThrow(IllegalArgumentException::new);
	}
}
