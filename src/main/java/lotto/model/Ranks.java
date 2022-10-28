package lotto.model;

import java.util.List;

public class Ranks {
	private final List<Rank> ranks;

	public Ranks(final List<Rank> ranks) {
		this.ranks = ranks;
	}

	public long getTotalPrize() {
		return ranks.stream()
			.mapToLong(Rank::prize)
			.sum();
	}

	public long count(final Rank searchRank) {
		return ranks.stream()
			.filter(rank -> rank == searchRank)
			.count();
	}
}
