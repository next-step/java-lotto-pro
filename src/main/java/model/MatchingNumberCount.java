package model;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum MatchingNumberCount {
	ONE(Count.from(1), BigDecimal.ZERO),
	TWO(Count.from(2), BigDecimal.ZERO),
	THREE(Count.from(3), BigDecimal.valueOf(5_000)),
	FOUR(Count.from(4), BigDecimal.valueOf(50_000)),
	FIVE(Count.from(5), BigDecimal.valueOf(1_500_000)),
	SIX(Count.from(6), BigDecimal.valueOf(2_000_000_000));

	private final Count matchCount;
	private final BigDecimal prizeMoney;
	private static final Map<Count, MatchingNumberCount> matchCountByCount = Arrays.stream(values())
		.collect(toMap(MatchingNumberCount::getMatchCount, Function.identity()));

	MatchingNumberCount(Count matchCount, BigDecimal prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static MatchingNumberCount getByCount(Count count) {
		return matchCountByCount.get(count);
	}

	public Count getMatchCount() {
		return matchCount;
	}

	public BigDecimal getPrizeMoney() {
		return prizeMoney;
	}
}
