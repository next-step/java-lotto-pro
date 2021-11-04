package lotto;

import lotto.domain.LottoController;

public class LottoMainApp {

	public static void main(String[] args) {
		LottoController controller = new LottoController();
		controller.start();
		// LottoApp lottoApp = new LottoApp();
		//
		// int money = InputView.getMoney();
		// int lottoCount = lottoApp.getLottoCountByMoney(money);
		// List<LottoNumber> numbers = lottoApp.getLottoNumbersByCount(lottoCount);
		// ResultView.showLottoNumbers(lottoCount, numbers);
		//
		// LottoNumber answer = LottoNumber.of(InputView.getLottoNumbers());
		// LottoPrize lottoPrize = lottoApp.calculatePoint(answer, numbers);
		// double profit = lottoApp.getProfit(money, lottoPrize);
		// ResultView.showPrize(lottoPrize, profit);
	}

}
