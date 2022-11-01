package lotto.domain.amount;

import java.util.HashMap;
import java.util.Map;

import lotto.domain.match.count.MatchCount;

public class MatchCountWinningPriceStrategy implements WinningPriceStrategy {
	private static final Map<MatchCount, Amount> WINNING_PRICE_MAP = new HashMap<MatchCount, Amount>() {{
		put(MatchCount.from(3), Amount.from(5000L));
		put(MatchCount.from(4), Amount.from(50000L));
		put(MatchCount.from(5), Amount.from(1500000L));
		put(MatchCount.from(6), Amount.from(2000000000L));
	}};

	private final MatchCount matchCount;

	public MatchCountWinningPriceStrategy(MatchCount matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public Amount winningPrice() {
		if (WINNING_PRICE_MAP.containsKey(matchCount)) {
			return WINNING_PRICE_MAP.get(matchCount);
		}
		return Amount.from(0);
	}
}
