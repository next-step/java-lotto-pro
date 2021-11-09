package step3.machine;

import step3.LottoNumbers;
import step3.LottoPapers;
import step3.Money;
import step3.view.InputView;
import step3.view.ResultView;
import step3.winner.Winner;
import step3.winner.WinningMoney;

public class LottoMachineFacade {

	private final Machine machine;
	private final InputView inputView;
	private final ResultView resultView;

	public LottoMachineFacade(Machine machine, InputView inputView, ResultView resultView) {
		this.machine = machine;
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void start() {
		Money money = new Money(inputView.insertMoney());
		createLottoPapers(money);
	}

	public void createLottoPapers(Money money) {

		machine.insertMoney(money);
		LottoPapers lottoPapers = machine.createLottoPapers();
		resultView.purchasedCount(money.buyCount());
		resultView.purchasedLottoPrint(lottoPapers);

		Winner winner = Winner.of();
		String userLottoNumbers = inputView.insertLottoNumber();
		Winner statistics = winner.statistics(LottoNumbers.from(userLottoNumbers), lottoPapers);
		int totalWinningAmount = statistics.getTotal();
		WinningMoney.calculateYield(money, totalWinningAmount);
	}

}