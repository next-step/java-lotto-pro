package lotto;

import java.util.List;

public class WinnerNumber {
	private LottoInput winnerNumber;

	public WinnerNumber(String input) {
		this.winnerNumber = new LottoInput(input);
	}

	public LottoInput getWinnerNumber() {
		return winnerNumber;
	}

	public int strikeCount(List<LottoNumber> compareList) {
		compareList.retainAll(this.winnerNumber.getInput());
		return compareList.size();
	}
}
