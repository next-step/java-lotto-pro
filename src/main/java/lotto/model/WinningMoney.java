package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningMoney {
	OTHER(0, 0), 
	FIFTH(3, 5_000), 
	FOURTH(4, 50_000), 
	THIRD(5, 1_500_000), 
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

	private static final Map<Long, WinningMoney> WINNING_MONEY_MAP = Collections
			.unmodifiableMap(Stream.of(values()).filter(WinningMoney::isNotSecondPlace)
					.collect(Collectors.toMap(WinningMoney::getMatchCount, Function.identity())));
	private static final long DEFAULT_WINNING_MONEY_KEY = 0L;

	private final int matchCount;
	private final int winningMoney;

	private WinningMoney(int matchCount, int winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
	}

	public long getMatchCount() {
		return matchCount;
	}

	public long getWinningMoney() {
		return winningMoney;
	}

	public long winningMoney(int count) {
		return (long)winningMoney * count;
	}

	public static WinningMoney find(long matchCount) {
		if (WINNING_MONEY_MAP.containsKey(matchCount)) {
			return WINNING_MONEY_MAP.get(matchCount);
		}
		return WINNING_MONEY_MAP.get(DEFAULT_WINNING_MONEY_KEY);
	}

	public boolean isSecondPlace() {
		return this == SECOND;
	}

	private boolean isNotSecondPlace() {
		return this != SECOND;
	}
}
