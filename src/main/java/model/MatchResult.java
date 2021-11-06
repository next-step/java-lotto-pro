package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchResult {
	private final Map<MatchingNumberCount, Count> countByMatchingNumberCount = new HashMap<>();

	public MatchResult() {
	}

	MatchResult(Count threeMatchCount, Count fourMatchCount, Count fiveMatchCount, Count sixMatchCount) {
		countByMatchingNumberCount.put(MatchingNumberCount.THREE, threeMatchCount);
		countByMatchingNumberCount.put(MatchingNumberCount.FOUR, fourMatchCount);
		countByMatchingNumberCount.put(MatchingNumberCount.FIVE, fiveMatchCount);
		countByMatchingNumberCount.put(MatchingNumberCount.SIX, sixMatchCount);
	}

	public BigDecimal calculateTotalPayout() {
		return MatchingNumberCount.THREE.getPrizeMoney().getValue().multiply(getThreeMatchCount().toBigDecimal())
		.add(MatchingNumberCount.FOUR.getPrizeMoney().getValue().multiply(getFourMatchCount().toBigDecimal()))
		.add(MatchingNumberCount.FIVE.getPrizeMoney().getValue().multiply(getFiveMatchCount().toBigDecimal()))
		.add(MatchingNumberCount.SIX.getPrizeMoney().getValue().multiply(getSixMatchCount().toBigDecimal()));
	}

	public void increaseByMatchCount(MatchingNumberCount matchingNumberCount) {
		countByMatchingNumberCount.merge(matchingNumberCount, Count.one(), Count::sum);
	}

	public Count getThreeMatchCount() {
		return countByMatchingNumberCount.getOrDefault(MatchingNumberCount.THREE, Count.zero());
	}

	public Count getFourMatchCount() {
		return countByMatchingNumberCount.getOrDefault(MatchingNumberCount.FOUR, Count.zero());
	}

	public Count getFiveMatchCount() {
		return countByMatchingNumberCount.getOrDefault(MatchingNumberCount.FIVE, Count.zero());
	}

	public Count getSixMatchCount() {
		return countByMatchingNumberCount.getOrDefault(MatchingNumberCount.SIX, Count.zero());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MatchResult that = (MatchResult)o;
		return Objects.equals(countByMatchingNumberCount, that.countByMatchingNumberCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(countByMatchingNumberCount);
	}
}
