package lotto;

import view.InputView;
import view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		LottoMain.play();
	}

	public static void play() {
		//투자금
		String inputInvestment = InputView.inputInvestment();
		Investment investment = new Investment(inputInvestment);
		//로또생성
		Lottos lottos = new Lottos(investment.getCount());
		ResultView.purchaseResult(lottos);

		//당첨번호
		String inputWinningNumber = InputView.inputWinningNumber();
		WinnerNumber winnerNumber = new WinnerNumber(inputWinningNumber);
		//보너스 번호
		String inputBonusBall = InputView.inputBonusBall();

		//결과 확인
		Winning winning = lottos.getWinningResult(winnerNumber);
		ResultView.totalResult(winning, investment.getInvestment());
	}
}
