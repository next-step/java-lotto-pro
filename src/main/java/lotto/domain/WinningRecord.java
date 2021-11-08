package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningRecord {

	public static final int DEFAULT_VALUE = 0;
	public static final int ADD = 1;

	private final Map<Long, Integer> record;
	private final long revenue;

	public WinningRecord(List<Rank> ranks) {
		Map<Long, Integer> record = new HashMap<>();
		for (Rank rank : ranks) {
			record.put(rank.getPrizeMoney(), record.getOrDefault(rank.getPrizeMoney(), DEFAULT_VALUE) + ADD);
		}
		this.record = record;
		this.revenue = record.entrySet().stream()
			.mapToLong(rankIntegerEntry -> rankIntegerEntry.getKey() * rankIntegerEntry.getValue())
			.sum();
	}

	public int getPlaceCount(Rank rank) {
		return this.record.getOrDefault(rank.getPrizeMoney(), DEFAULT_VALUE);
	}

	public long getRevenue() {
		return revenue;
	}
}
