package lotto.domain.wrapper;

import java.util.HashMap;
import java.util.Map;

public class HitsByMatchedNumberCount {
	private static final Map<Integer, Integer> DEFAULT;
	private static final int ZERO_TIMES = 0;

	static {
		DEFAULT = new HashMap<>();
		LottoWinningMoney.get().keySet().stream().forEach(x -> DEFAULT.put(x, ZERO_TIMES));
	}

	private Map<Integer, Integer> timesByMatchedNumberCount;

	public HitsByMatchedNumberCount() {
		this.timesByMatchedNumberCount = new HashMap<>(DEFAULT);
	}

	public void hit(int matchedNumberCount) {
		this.timesByMatchedNumberCount.computeIfPresent(matchedNumberCount, (k, v) -> ++v);
	}

	public Integer getHitsByMatchedNumberCount(int matchedNumberCount) {
		return this.timesByMatchedNumberCount.get(matchedNumberCount);
	}

	public Map<Integer, Integer> get() {
		return new HashMap<>(this.timesByMatchedNumberCount);
	}
}
