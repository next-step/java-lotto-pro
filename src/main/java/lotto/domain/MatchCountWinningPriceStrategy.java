package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchCountWinningPriceStrategy implements WinningPriceStrategy {
	private static final Map<MatchCount, Price> WINNING_PRICE_MAP = new HashMap<MatchCount, Price>() {{
		put(MatchCount.from(3), Price.from(5000L));
		put(MatchCount.from(4), Price.from(50000L));
		put(MatchCount.from(5), Price.from(1500000L));
		put(MatchCount.from(6), Price.from(2000000000L));
	}};

	private final MatchCount matchCount;

	public MatchCountWinningPriceStrategy(MatchCount matchCount) {
		this.matchCount = matchCount;
	}

	@Override
	public Price winningPrice() {
		if (WINNING_PRICE_MAP.containsKey(matchCount)) {
			return WINNING_PRICE_MAP.get(matchCount);
		}
		return Price.from(0);
	}
}
