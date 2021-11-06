package step3;

public class LottoMachineFacade {

	public static LottoPapers PAPER;
	private Money money;

	public LottoMachineFacade() {
		PAPER = LottoPapers.getInstance();
	}

	public void pick(int insertMoney) {
		money = new Money(insertMoney);
		Machine machine = new Machine(money);
		machine.createLotto();
	}

	public void result(String userInputWinnerNumber) {
		Winner winner = new Winner();
		winner.statistics(userInputWinnerNumber);
		winner.yield(money);
		ResultView.statisticsPrintAndYield(winner);
	}
}
