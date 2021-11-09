package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class LottoApplicationController {


	private Lottos lottos;

	public void purchaseLotto(Money purchaseAmount) {
		this.lottos = LottoShop.sell(purchaseAmount);
	}

	public List<Lotto> recorde(String winningNumbers, int bonusBallNumber) {
		for (Lotto lotto : lottos.getLottos()) {
			lotto.recordeRank(new LottoNumbers(winningNumbers), new LottoNumber(bonusBallNumber));
		}
		return lottos.getLottos();
	}

	public List<Lotto> getLottos() {
		return lottos.getLottos();
	}
}
