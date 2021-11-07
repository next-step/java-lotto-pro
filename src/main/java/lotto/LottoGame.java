package lotto;

import java.util.LinkedList;
import java.util.List;

public class LottoGame {
	private final Lotto winLotto;

	public LottoGame(Lotto winLotto) {
		this.winLotto = winLotto;
	}

	public Prize winPrize(Lottos lottos) {
		List<Numbers> numbers = new LinkedList<>();
		for (Lotto lotto : lottos) {
			numbers.add(winLotto.compareNumbers(lotto));
		}
		return new Prize(numbers);
	}
}
