package lotto;

import view.InputView;
import view.ResultView;

public class LottoMain {
	private Investment investment;
	private Lottos lottos;
	private WinnerNumber winnerNumber;
	private BonusBall bonusBall;

	public LottoMain() {
	}

	public static void main(String[] args) {
		LottoMain lottoMain = new LottoMain();
		lottoMain.play();
	}

	public void play() {
		setInvestment();
		//로또생성
		lottos = new Lottos(investment.getCount());
		ResultView.purchaseResult(lottos);
		setWinnerNumber();
		setBonusBall();
		//결과 확인
		Winning winning = lottos.getWinningResult(winnerNumber, bonusBall);
		ResultView.totalResult(winning, investment.getInvestment());
	}

	private void setInvestment() {
		try {
			//투자금
			String inputInvestment = InputView.inputInvestment();
			investment = new Investment(inputInvestment);
		} catch (IllegalArgumentException e) {
			ResultView.print(e.getMessage());
			setInvestment();
		}
	}

	private void setWinnerNumber() {
		try {
			//당첨번호
			String inputWinningNumber = InputView.inputWinningNumber();
			winnerNumber = new WinnerNumber(inputWinningNumber);
		} catch (IllegalArgumentException e) {
			ResultView.print(e.getMessage());
			setWinnerNumber();
		}
	}

	private void setBonusBall() {
		try {
			//보너스 번호
			String inputBonusBall = InputView.inputBonusBall();
			bonusBall = new BonusBall(inputBonusBall, winnerNumber);
		} catch (IllegalArgumentException e) {
			ResultView.print(e.getMessage());
			setBonusBall();
		}
	}
}
