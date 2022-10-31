package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Ranks {
	private final List<Rank> ranks;

	public Ranks(final List<Rank> ranks) {
		this.ranks = ranks;
	}

	public Money getTotalPrize() {
		return ranks.stream()
			.map(Rank::prize)
			.collect(collectingAndThen(summingLong(Long::longValue), Money::new));
	}

	public long count(final Rank searchRank) {
		return ranks.stream()
			.filter(rank -> rank == searchRank)
			.count();
	}

	public float getIncomeRatio() {
		return Lotto.LOTTO_PRICE
			.multiply(ranks.size())
			.ratio(getTotalPrize());
	}
}
