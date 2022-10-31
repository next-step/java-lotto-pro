package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranks {

	private final List<Rank> ranks;

	private Ranks(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public static Ranks from(List<Integer> matchCounts) {
		return new Ranks(matchCounts.stream()
				.map(Rank::from)
				.collect(Collectors.toList()));
	}
	private Map<Rank, Long> initResultMap() {
		Map<Rank, Long> resultRankMap = new LinkedHashMap<>();
		Arrays.stream(Rank.values())
			.filter(r -> !r.equals(Rank.LOSE))
			.sorted(Comparator.comparingInt(Rank::getMatchCount))
			.forEach(r -> resultRankMap.put(r, 0L));
		return resultRankMap;
	}


	public Map<Rank, Long> groupBy() {
		Map<Rank, Long> resultRankMap = initResultMap();
		ranks.forEach(rank -> resultRankMap.computeIfPresent(rank, (key, value) -> ++value));
		return resultRankMap;
	}
}
