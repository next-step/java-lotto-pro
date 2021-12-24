package lotto.domain.wrapper;

import java.util.HashMap;
import java.util.Map;

public final class HitsByRank {
	private static final Map<Rank, Integer> DEFAULT;
	private static final int ZERO_TIMES = 0;

	static {
		DEFAULT = new HashMap<>();
		for (Rank rank : Rank.values()) {
			DEFAULT.put(rank, ZERO_TIMES);
		}
	}

	private Map<Rank, Integer> timesByMatchedNumberCount;

	public HitsByRank() {
		this.timesByMatchedNumberCount = new HashMap<>(DEFAULT);
	}

	public void hit(Rank rank) {
		this.timesByMatchedNumberCount.computeIfPresent(rank, (k, v) -> ++v);
	}

	public Integer getHitsByRank(Rank rank) {
		return this.timesByMatchedNumberCount.get(rank);
	}

	public Map<Rank, Integer> get() {
		return new HashMap<>(this.timesByMatchedNumberCount);
	}
}
