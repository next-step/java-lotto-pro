package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningRecord {

	public static final int DEFAULT_VALUE = 0;
	public static final int ADD = 1;
	public static final int DECIMAL_POINT = 2;

	private final Map<Long, Integer> record;
	private final long revenue;

	public WinningRecord(List<Rank> ranks) {
		this.record = generateRecord(ranks);
		this.revenue = getSum();
	}

	private long getSum() {
		return record.entrySet().stream()
			.mapToLong(rankIntegerEntry -> rankIntegerEntry.getKey() * rankIntegerEntry.getValue())
			.sum();
	}

	private Map<Long, Integer> generateRecord(List<Rank> ranks) {
		Map<Long, Integer> record = new HashMap<>();
		for (Rank rank : ranks) {
			record.put(rank.getPrizeMoney(), record.getOrDefault(rank.getPrizeMoney(), DEFAULT_VALUE) + ADD);
		}
		return record;
	}

	public int getPlaceCount(Rank rank) {
		return this.record.getOrDefault(rank.getPrizeMoney(), DEFAULT_VALUE);
	}

	public double profitRate(double standard) {
		return new BigDecimal(revenue / standard)
			.setScale(DECIMAL_POINT, RoundingMode.FLOOR)
			.doubleValue();
	}
}
