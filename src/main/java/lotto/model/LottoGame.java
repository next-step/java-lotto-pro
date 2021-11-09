package lotto.model;

import java.util.LinkedList;
import java.util.List;

import lotto.constants.Rank;

public class LottoGame {
	private final Lotto winLotto;

	public LottoGame(Lotto winLotto) {
		this.winLotto = winLotto;
	}

	public Prize winPrize(Lottos lottos) {
		List<Rank> ranks = new LinkedList<>();
		for (Lotto lotto : lottos) {
			ranks.add(winLotto.compare(lotto));
		}
		return new Prize(ranks);
	}
}
