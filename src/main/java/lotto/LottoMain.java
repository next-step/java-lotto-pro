package lotto;

import view.InputView;
import view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		LottoMain.play();
	}

	public static void play() {
		String inputInvestment = InputView.inputInvestment();

		Investment investment = new Investment(inputInvestment);
		Lottos lottos = new Lottos(investment.getCount());
		ResultView.purchaseResult(lottos);

		String inputWinningNumber = InputView.inputWinningNumber();
		WinnerNumber winnerNumber = new WinnerNumber(inputWinningNumber);
		Winning winning = lottos.getWinningResult(winnerNumber);
		ResultView.totalResult(winning, investment.getInvestment());
	}
}
