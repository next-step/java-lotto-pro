package lotto;

import java.util.List;

import lotto.domain.LottoApp;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMainApp {

	public static void main(String[] args) {
		LottoApp lottoApp = new LottoApp();

		int money = InputView.getMoney();
		int lottoCount = lottoApp.getLottoCountByMoney(money);
		List<LottoNumber> numbers = lottoApp.getLottoNumbersByCount(lottoCount);
		ResultView.showLottoNumbers(lottoCount, numbers);

		LottoNumber answer = LottoNumber.of(InputView.getLottoNumbers());
		LottoPrize lottoPrize = lottoApp.calculatePoint(answer, numbers);
		double profit = lottoApp.getProfit(money, lottoPrize);
		ResultView.showPrize(lottoPrize, profit);
	}

}
