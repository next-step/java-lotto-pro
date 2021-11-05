package lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoList {
	private List<Lotto> lottoList;

	public LottoList(Integer count) {
		this.lottoList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			this.lottoList.add(new Lotto());
		}
	}

	public LottoList() {
		this.lottoList = new ArrayList<>();
	}

	public int size() {
		return lottoList.size();
	}

	public Winning getWinningResult(Lotto winnerNumber, BonusBall bonusBall) {
		Winning winning = new Winning();

		for (Lotto lotto : lottoList) {
			int strikeCount = winnerNumber.compareCount(lotto);
			boolean matchBonus = bonusBall.matched(lotto);
			winning.addWinningMap(strikeCount, matchBonus);
		}

		return winning;
	}

	public void addAll(LottoList addList) {
		this.lottoList.addAll(addList.lottoList);
	}

	@Override
	public String toString() {
		return lottoList.toString();
	}

	public void addLottoList(Lotto lotto) {
		lottoList.add(lotto);
	}
}
