package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	private final List<LottoNumber> lottoNumbers = new ArrayList<>();
	private int money = 0;

	public void start() {
		buyLotto();
		checkProfit();
	}

	private void buyLotto() {
		this.money = InputView.getMoney();
		int lottoCount = LottoPurchase.getLottoCount(this.money);
		for (int i = 0; i < lottoCount; i++) {
			lottoNumbers.add(LottoNumberGenerator.generate());
		}
		ResultView.showLottoNumbers(lottoCount, lottoNumbers);
	}

	private void checkProfit() {
		LottoNumber winingNumber = LottoNumber.of(InputView.getLottoNumbers());
		LottoRanks ranks = new LottoRanks(winingNumber, lottoNumbers);
		LottoPrizes prizes = new LottoPrizes(ranks);
		double profit = LottoProfit.calculate(prizes.getTotalPrizeMoney(), this.money);
		ResultView.showPrize(ranks, profit);
	}

}
