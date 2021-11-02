package lotto;

import static lotto.common.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.StringInput;
import lotto.common.Messages;

public class WinnerNumber {
	private LottoInput winnerNumber;

	public WinnerNumber(String input) {
		this.winnerNumber = new LottoInput(input);
	}

	public LottoInput getWinnerNumber() {
		return winnerNumber;
	}

	public int strikeCount(List<Integer> compareList) {
		compareList.retainAll(this.winnerNumber.getInput());
		return compareList.size();
	}
}
