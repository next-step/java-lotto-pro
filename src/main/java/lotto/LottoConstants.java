package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoConstants {
	public static final Map<Integer, Integer> PRIZE_LIST;
	public static final int PRICE = 1000;

	static {
		PRIZE_LIST = new HashMap<>();
		PRIZE_LIST.put(3, 5000);
		PRIZE_LIST.put(4, 50000);
		PRIZE_LIST.put(5, 1500000);
		PRIZE_LIST.put(6, 2000000000);
	}
}
