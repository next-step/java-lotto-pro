package model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum MatchingNumberCount {
	ONE(Count.from(1), Money.of(0)),
	TWO(Count.from(2), Money.of(0)),
	THREE(Count.from(3), Money.of(5_000)),
	FOUR(Count.from(4), Money.of(50_000)),
	FIVE(Count.from(5), Money.of(1_500_000)),
	SIX(Count.from(6), Money.of(2_000_000_000));

	private final Count matchCount;
	private final Money prizeMoney;
	private static final Map<Count, MatchingNumberCount> matchCountByCount = Arrays.stream(values())
		.collect(toMap(MatchingNumberCount::getMatchCount, Function.identity()));

	MatchingNumberCount(Count matchCount, Money prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static MatchingNumberCount getByCount(Count count) {
		return matchCountByCount.get(count);
	}

	public Count getMatchCount() {
		return matchCount;
	}

	public Money getPrizeMoney() {
		return prizeMoney;
	}
}
