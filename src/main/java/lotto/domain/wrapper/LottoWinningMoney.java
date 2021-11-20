package lotto.domain.wrapper;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningMoney {
	public static final Map<Integer, Integer> WINNING_MONEY_BY_MATCHED_NUMBER_COUNT;

	static {
		WINNING_MONEY_BY_MATCHED_NUMBER_COUNT = new HashMap<>();
		WINNING_MONEY_BY_MATCHED_NUMBER_COUNT.put(3, 5000);
		WINNING_MONEY_BY_MATCHED_NUMBER_COUNT.put(4, 50000);
		WINNING_MONEY_BY_MATCHED_NUMBER_COUNT.put(5, 1500000);
		WINNING_MONEY_BY_MATCHED_NUMBER_COUNT.put(6, 2000000000);
	}

	public static Map<Integer, Integer> get() {
		return WINNING_MONEY_BY_MATCHED_NUMBER_COUNT;
	}

	public static Integer getMoneyByMatchedNumberCount(Integer matchedNumberCount) {
		return WINNING_MONEY_BY_MATCHED_NUMBER_COUNT.get(matchedNumberCount);
	}
}
