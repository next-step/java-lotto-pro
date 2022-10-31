package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinningPrice {
	private static final Map<MatchCount, WinningPrice> WINNING_PRICE_MAP = new HashMap<MatchCount, WinningPrice>() {{
		put(MatchCount.from(3), new WinningPrice(5000L));
		put(MatchCount.from(4), new WinningPrice(50000L));
		put(MatchCount.from(5), new WinningPrice(1500000L));
		put(MatchCount.from(6), new WinningPrice(2000000000L));
	}};

	private final long winningPrice;

	public WinningPrice(long winningPrice) {
		this.winningPrice = winningPrice;
	}

	public static WinningPrice from(MatchCount matchCount) {
		return WINNING_PRICE_MAP.get(matchCount);
	}

	public long getLong() {
		return this.winningPrice;
	}

	public WinningPrice sum(WinningPrice other) {
		return new WinningPrice(this.winningPrice + other.winningPrice);
	}

	public float div(int quantity) {
		return (float)this.winningPrice / quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WinningPrice that = (WinningPrice)o;
		return winningPrice == that.winningPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(winningPrice);
	}
}
