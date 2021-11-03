package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private List<Lotto> lottoList;

	public Lottos(int count) {
		lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottoList.add(new Lotto());
		}
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}

	public Winning getWinningResult(WinnerNumber winnerNumber) {
		Winning winning = new Winning();

		for (Lotto lotto : lottoList) {
			int strikeCount = winnerNumber.strikeCount(lotto.getNumbers());
			winning.addWinningMap(strikeCount);
		}

		return winning;
	}
}
