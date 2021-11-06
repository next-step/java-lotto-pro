package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRecord {

	public static final int DEFAULT_VALUE = 0;
	public static final int ADD = 1;

	private final Map<Rank, Integer> record;

	public LottoRecord(List<Rank> ranks) {
		Map<Rank, Integer> record = new HashMap<>();
		for (Rank rank : ranks) {
			record.put(rank, record.getOrDefault(rank, DEFAULT_VALUE) + ADD);
		}
		this.record = record;
	}

	public int getPlaceCount(Rank rank) {
		return this.record.getOrDefault(rank, DEFAULT_VALUE);
	}
}
