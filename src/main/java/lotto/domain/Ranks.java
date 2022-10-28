package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ranks {

	private final List<Rank> ranks;

	private Ranks(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public static Ranks of(List<Rank> ranks) {
		return new Ranks(ranks);
	}

	public Map<Rank, Long> groupBy() {
		return ranks.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}
