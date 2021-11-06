package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WinningRecord {
	private final LinkedHashMap<Integer, WinningInformation> winningRecord = new LinkedHashMap<>();

	public WinningRecord() {
		int[] ranks = {CommonConstant.FIFTH_PLACE, CommonConstant.FOURTH_PLACE,
						CommonConstant.THIRD_PLACE, CommonConstant.FIRST_PLACE};
		int[] winningAmount = {CommonConstant.FIFTH_AMOUNT, CommonConstant.FOURTH_AMOUNT,
						CommonConstant.THIRD_AMOUNT, CommonConstant.FIRST_AMOUNT};
		for (int i = CommonConstant.FIRST_INDEX; i < ranks.length; i++) {
			winningRecord.put(ranks[i],
				new WinningInformation(ranks[i], winningAmount[i], CommonConstant.DEFAULT_VALUE));
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
