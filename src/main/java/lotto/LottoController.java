package lotto;

import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrizes;
import lotto.domain.LottoProfit;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoRanks;
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
		List<Integer> numbers = InputView.getLottoNumbers();
		int bonusNumber = InputView.getBonusNumber();
		LottoNumber winingNumber = LottoNumber.of(numbers, bonusNumber);
		LottoRanks ranks = new LottoRanks(winingNumber, this.lottoNumbers);
		LottoPrizes prizes = new LottoPrizes(ranks);
		double profit = LottoProfit.calculate(prizes.getTotalPrizeMoney(), this.money);
		ResultView.showPrize(ranks, profit);
	}

}
