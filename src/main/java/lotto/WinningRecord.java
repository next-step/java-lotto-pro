package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WinningRecord {
	private static final int DEFAULT_VALUE = 0;
	private static final int FIFTH_PLACE = 3;
	private static final int FOURTH_PLACE = 4;
	private static final int THIRD_PLACE = 5;
	private static final int FIRST_PLACE = 6;
	private static final int FIFTH_AMOUNT = 5000;
	private static final int FOURTH_AMOUNT = 50000;
	private static final int THIRD_AMOUNT = 1500000;
	private static final int FIRST_AMOUNT = 2000000000;
	private static final int FIRST_INDEX = 0;

	private final LinkedHashMap<Integer, WinningInformation> winningRecord = new LinkedHashMap<>();

	public WinningRecord() {
		int[] ranks = {FIFTH_PLACE, FOURTH_PLACE, THIRD_PLACE, FIRST_PLACE};
		int[] winningAmount = {FIFTH_AMOUNT, FOURTH_AMOUNT, THIRD_AMOUNT, FIRST_AMOUNT};
		for (int i = FIRST_INDEX; i < ranks.length; i++) {
			winningRecord.put(ranks[i],
				new WinningInformation(ranks[i], winningAmount[i], DEFAULT_VALUE));
		}
	}

	public void record(MatchedNumber matchedNumber) {
		WinningInformation winningInformation = winningRecord.get(matchedNumber.value());
		winningInformation.addWinner();
		winningRecord.put(matchedNumber.value(), winningInformation);
	}

	public List<WinningInformation> getWinningRecord() {
		return winningRecord.values().stream().collect(Collectors.toList());
	}
}
