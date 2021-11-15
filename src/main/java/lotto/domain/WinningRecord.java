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

	private final Map<Rank, Integer> record;
	private final long revenue;

	public WinningRecord(List<Rank> ranks) {
		this.record = generateRecord(ranks);
		this.revenue = getSum();
	}

	private long getSum() {
		return record.entrySet().stream()
			.mapToLong(rankIntegerEntry -> rankIntegerEntry
				.getKey().getPrizeMoney() * rankIntegerEntry.getValue())
			.sum();
	}

	private Map<Rank, Integer> generateRecord(List<Rank> ranks) {
		Map<Rank, Integer> record = new HashMap<>();
		for (Rank rank : ranks) {
			record.put(rank, record.getOrDefault(rank, DEFAULT_VALUE) + ADD);
		}
		return record;
	}

	public int getPlaceCount(Rank rank) {
		return this.record.getOrDefault(rank, DEFAULT_VALUE);
	}

	public double profitRate(double standard) {
		return BigDecimal.valueOf(revenue)
			.divide(BigDecimal.valueOf(standard), DECIMAL_POINT, RoundingMode.FLOOR)
			.doubleValue();
	}
}
