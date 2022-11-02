package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ranks {

	private final List<Rank> ranks;

	private Ranks(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public static Ranks from(List<Rank> ranks) {
		return new Ranks(ranks);
	}

	public Map<Rank, Long> groupBy() {
		Map<Rank, Long> resultRankMap = initResultMap();
		ranks.forEach(rank -> resultRankMap.computeIfPresent(rank, (key, value) -> ++value));
		return resultRankMap;
	}

	public RankResult rankResults() {
		return RankResult.from(groupBy());
	}

	public int size() {
		return ranks.size();
	}

	private Map<Rank, Long> initResultMap() {
		Map<Rank, Long> resultRankMap = new LinkedHashMap<>();
		Arrays.stream(Rank.values())
			.filter(r -> !r.equals(Rank.LOSE))
			.sorted(Comparator.comparingLong(Rank::getPrize))
			.forEach(r -> resultRankMap.put(r, 0L));
		return resultRankMap;
	}
}
