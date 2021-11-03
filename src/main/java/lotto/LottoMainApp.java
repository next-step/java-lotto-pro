package lotto;

import java.util.List;

import lotto.domain.LottoApp;
import lotto.domain.LottoNumber;
import lotto.domain.MatchPoint;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMainApp {

	public static void main(String[] args) {
		LottoApp lottoApp = new LottoApp();

		int money = InputView.getMoney();
		int lottoCount = lottoApp.getLottoCountByMoney(money);
		List<LottoNumber> numbers = lottoApp.getLottoNumbersByCount(lottoCount);
		OutputView.showLottoNumbers(lottoCount, numbers);

		LottoNumber answer = new LottoNumber(InputView.getLottoNumbers());
		MatchPoint matchPoint = lottoApp.calculatePoint(answer, numbers);
		double profit = lottoApp.getProfit(money, matchPoint);
		OutputView.showPrize(matchPoint, profit);
	}

}
