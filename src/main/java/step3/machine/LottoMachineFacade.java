package step3.machine;

import java.math.BigDecimal;

import step3.Money;
import step3.lotto.BonusBall;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.view.InputView;
import step3.view.ResultView;
import step3.winner.Winning;
import step3.winner.WinningMoney;
import step3.winner.WinningResult;
import step3.winner.WinningResultMap;

public class LottoMachineFacade {

	private final Machine machine;
	private final InputView inputView;
	private final ResultView resultView;

	public LottoMachineFacade(Machine machine, InputView inputView, ResultView resultView) {
		this.machine = machine;
		this.inputView = inputView;
		this.resultView = resultView;
	}


	public void LottoMachineExecute() {

		try {
			Money money = enterMoney();
			LottoPapers lottoPapers = machine.createLottoPapers(money);

			resultView.purchasedCount(money.buyCount());
			resultView.purchasedLottoPrint(lottoPapers);

			LottoNumbers userLottoNumbers = enterUserLottoNumber();
			BonusBall bonusBall = enterBonusBall(userLottoNumbers);

			Winning winning = new Winning(userLottoNumbers, bonusBall);
			WinningResult winningResult = winning.match(lottoPapers);
			WinningResultMap winningResultMap = winningResult.getStatistics();
			resultView.statisticsPrint(winningResultMap);
			BigDecimal yield = WinningMoney.calculateYield(money, winningResult.getTotal());
			resultView.yieldPrint(yield);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	private LottoNumbers enterUserLottoNumber() {
		String userLottoNumbers = inputView.insertLottoNumber();
		return LottoNumbers.from(userLottoNumbers);
	}

	private Money enterMoney() {
		Money money = new Money(inputView.insertMoney());
		return money;
	}

	private BonusBall enterBonusBall(LottoNumbers userLottoNumbers) {
		int bonusBall = inputView.insertBonusBall();
		return BonusBall.of(bonusBall, userLottoNumbers);
	}

}