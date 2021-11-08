import java.util.HashMap;
import java.util.Map;

public enum LottoWinningRank {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	OTHER(0, 0);

	private static final Map<Integer, LottoWinningRank> BY_MATCHING_COUNT = new HashMap<>();

	static {
		for (LottoWinningRank rank : values()) {
			if (isSecondOrThird(rank)) {
				continue;
			}
			BY_MATCHING_COUNT.put(rank.matchingCount, rank);
		}
	}

	private static boolean isSecondOrThird(LottoWinningRank rank) {
		return LottoWinningRank.SECOND == rank || LottoWinningRank.THIRD == rank;
	}

	public static LottoWinningRank valueOf(int matchingCount, boolean hasBonus) {
		if (isSecond(matchingCount, hasBonus)) {
			return LottoWinningRank.SECOND;
		} else if (isThird(matchingCount, hasBonus)) {
			return LottoWinningRank.THIRD;
		} else if (BY_MATCHING_COUNT.containsKey(matchingCount)) {
			return BY_MATCHING_COUNT.get(matchingCount);
		}
		return LottoWinningRank.OTHER;
	}

	private static boolean isSecond(int matchingCount, boolean hasBonus) {
		return hasBonus && (LottoWinningRank.SECOND.matchingCount == matchingCount);
	}

	private static boolean isThird(int matchingCount, boolean hasBonus) {
		return !hasBonus && (LottoWinningRank.THIRD.matchingCount == matchingCount);
	}

	LottoWinningRank(int matchingCount, int prizeKRW) {
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
