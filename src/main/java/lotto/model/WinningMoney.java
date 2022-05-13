package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningMoney {
	OTHER(0, 0),
	THREE(3, 5000),
	FOUR(4, 50000), 
	FIVE(5, 1500000), 
	SIX(6, 2000000000); 

	private static final Map<Integer, WinningMoney> WINNING_MONEY_MAP = Collections.unmodifiableMap(
			Stream.of(values()).collect(Collectors.toMap(WinningMoney::getMatchCount, Function.identity())));
	private static final int DEFAULT_WINNING_MONEY_KEY = 0;
	
	private final int matchCount;
	private final int winningMoney;

	private WinningMoney(int matchCount, int winningMoney) {
		this.matchCount = matchCount;
		this.winningMoney = winningMoney;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public int winningMoney(int count) {
		return winningMoney * count;
	}

	public static WinningMoney find(int matchCount) {
		if (WINNING_MONEY_MAP.containsKey(matchCount)) {
			return WINNING_MONEY_MAP.get(matchCount);
		}
		return WINNING_MONEY_MAP.get(DEFAULT_WINNING_MONEY_KEY);
//		throw new IllegalArgumentException("matchCount: " + matchCount + " WinningMoney Enum에 등록되어있지 않습니다.");
	}
}
