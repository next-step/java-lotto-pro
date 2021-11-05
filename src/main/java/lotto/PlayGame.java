package lotto;

import exception.BusinessException;
import investment.Investment;
import view.InputView;
import view.ResultView;

public class PlayGame {

	private Investment investment;
	private Lotto winnerNumber;
	private BonusBall bonusBall;

	public void play() {
		setInvestment();
		//로또생성

		// ResultView.purchaseResult(lottos);
		// setWinnerNumber();
		// setBonusBall();
		// //결과 확인
		// Winning winning = lottos.getWinningResult(winnerNumber, bonusBall);
		// ResultView.totalResult(winning, investment.getInvestment());
	}

	private void setInvestment() {
		try {
			//투자금
			String inputInvestment = InputView.inputInvestment();
			investment = new Investment(inputInvestment);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			setInvestment();
		}
	}

	private void setManualCount() {
		try {
			String inputManualCount = InputView.inputManualCount();
		}catch (BusinessException e) {
			ResultView.print(e.getMessage());
			setManualCount();
		}
	}

	private void setWinnerNumber() {
		try {
			//당첨번호
			String inputWinningNumber = InputView.inputWinningNumber();
			winnerNumber = new Lotto(inputWinningNumber);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			setWinnerNumber();
		}
	}

	private void setBonusBall() {
		try {
			//보너스 번호
			String inputBonusBall = InputView.inputBonusBall();
			bonusBall = new BonusBall(inputBonusBall);
		} catch (BusinessException e) {
			ResultView.print(e.getMessage());
			setBonusBall();
		}
	}
}
