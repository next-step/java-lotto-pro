package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RewardCalculator {
	public static final int DEFAULT_COUNT = 0;

	private final Map<Rank, Integer> rankMatchingCounts;

	public RewardCalculator() {
		this.rankMatchingCounts = new HashMap<>();
	}

	private RewardCalculator(Map<Rank, Integer> rankMatchingCounts) {
		this();
		for (Rank key : rankMatchingCounts.keySet()) {
			addCount(key, rankMatchingCounts.get(key));
		}
	}

	public void addCount(Rank rank) {
		int rankCount = rankMatchingCounts.getOrDefault(rank, DEFAULT_COUNT);
		rankMatchingCounts.put(rank, rankCount + 1);
	}

	public int getCount(Rank rank) {
		return rankMatchingCounts.getOrDefault(rank, DEFAULT_COUNT);
	}

	public long sumReward() {
		long sum = 0;
		for (Rank rank : rankMatchingCounts.keySet()) {
			sum += (long)rankMatchingCounts.get(rank) * rank.getReward();
		}
		return sum;
	}

	public RewardCalculator sum(RewardCalculator other) {
		RewardCalculator rewardCalculator = new RewardCalculator(this.rankMatchingCounts);
		for (Rank key : other.rankMatchingCounts.keySet()) {
			rewardCalculator.addCount(key, other.rankMatchingCounts.get(key));
		}
		return rewardCalculator;
	}

	public void addCount(Rank key, int value) {
		rankMatchingCounts.put(key, value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RewardCalculator that = (RewardCalculator)o;
		return Objects.equals(rankMatchingCounts, that.rankMatchingCounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rankMatchingCounts);
	}
}
