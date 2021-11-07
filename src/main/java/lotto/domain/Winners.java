package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Winners {
	private static final int DEFAULT_VALUE = 0;
	private static final int ADD_VALUE = 1;
	private final Map<Integer, Integer> winners = new HashMap<>();

	public void record(int matchedNumber) {
		winners.put(matchedNumber, winners.getOrDefault(matchedNumber, DEFAULT_VALUE) + ADD_VALUE);
	}

	public int count(int matchedNumber) {
		return Optional.ofNullable(winners.get(matchedNumber))
			.orElse(0);
	}
}
