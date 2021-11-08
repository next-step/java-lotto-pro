package lotto2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RankCounts {

	private final Map<Rank, Integer> rankAndCount;

	private RankCounts(Map<Rank, Integer> rankAndCount) {
		this.rankAndCount = new HashMap<>(rankAndCount);
	}

	public static RankCounts of(Map<Rank, Integer> rankAndCount) {
		return new RankCounts(rankAndCount);
	}

	public Set<Map.Entry<Rank, Integer>> entrySet() {
		return rankAndCount.entrySet();
	}

	public int get(String rankName) {
		return this.rankAndCount.get(Rank.valueOf(rankName));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RankCounts that = (RankCounts)o;

		return rankAndCount.equals(that.rankAndCount);
	}

	@Override
	public int hashCode() {
		return rankAndCount.hashCode();
	}
}
