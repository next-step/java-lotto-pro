package lotto.domain;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	private LottoNumbers lottoNumbers;
	private int money = 0;

	public void start() {
		buyLotto();
		checkProfit();
	}

	private void buyLotto() {
		this.money = InputView.getMoney();
		int lottoCount = LottoPurchase.getLottoCount(this.money);
		this.lottoNumbers = LottoNumberGenerator.generateByCount(lottoCount);
		ResultView.showLottoNumbers(lottoCount, lottoNumbers);
	}

	private void checkProfit() {
		LottoNumber winingNumber = LottoNumber.of(InputView.getLottoNumbers());
		LottoRanks ranks = new LottoRanks(winingNumber, this.lottoNumbers);
		LottoPrizes prizes = new LottoPrizes(ranks);
		double profit = LottoProfit.calculate(prizes.getTotalPrizeMoney(), this.money);
		ResultView.showPrize(ranks, profit);
	}

}
