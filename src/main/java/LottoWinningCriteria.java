import java.util.HashMap;
import java.util.Map;

public enum LottoWinningCriteria {

	FIRST_CLASS(6, 2_000_000_000),
	SECOND_CLASS(5, 1_500_000),
	THIRD_CLASS(4, 50_000),
	FOURTH_CLASS(3, 5_000),
	OTHER(-1, 0);

	private static final Map<Integer, LottoWinningCriteria> BY_MATCHING_COUNT = new HashMap<>();

	static {
		for (LottoWinningCriteria w : values()) {
			BY_MATCHING_COUNT.put(w.getMatchingCount(), w);
		}
	}

	public static LottoWinningCriteria valueOf(int matchingCount) {
		if (BY_MATCHING_COUNT.containsKey(matchingCount)) {
			return BY_MATCHING_COUNT.get(matchingCount);
		}
		return LottoWinningCriteria.OTHER;
	}

	LottoWinningCriteria(int matchingCount, int prizeKRW) {
		this.matchingCount = matchingCount;
		this.prizeKRW = prizeKRW;
	}

	private final int matchingCount;
	private final int prizeKRW;

	public int getMatchingCount() {
		return matchingCount;
	}

	public int getPrizeKRW() {
		return prizeKRW;
	}
}
