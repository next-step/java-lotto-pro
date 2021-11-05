package lottoLegacy;

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

	public Winning getWinningResult(WinnerNumber winnerNumber, BonusBall bonusBall) {
		Winning winning = new Winning();

		for (Lotto lotto : lottoList) {
			int strikeCount = winnerNumber.strikeCount(lotto.getNumbers());
			boolean matchBonus = bonusBall.match(lotto.getNumbers());
			winning.addWinningMap(strikeCount, matchBonus);
		}

		return winning;
	}
}
