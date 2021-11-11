package step3.machine;

import java.math.BigDecimal;
import java.util.List;

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
			Money money = enterMoney();
			int manualCount = enterManualCount();
			LottoPapers lottoPapers = createLottoPapers(money, manualCount);

			LottoNumbers userLottoNumbers = enterUserLottoNumber();
			BonusBall bonusBall = enterBonusBall(userLottoNumbers);

			Winning winning = new Winning(userLottoNumbers, bonusBall);
			WinningResult winningResult = winning.match(lottoPapers);
			WinningResultMap winningResultMap = winningResult.getStatistics();
			resultView.statisticsPrint(winningResultMap);
			BigDecimal yield = WinningMoney.calculateYield(money, winningResult.getTotal());
			resultView.yieldPrint(yield);
	}

	private Money enterMoney() {
		Money money = new Money(inputView.insertMoney());
		return money;
	}

	private int enterManualCount() {
		return inputView.insertManualCount();
	}

	private LottoPapers createLottoPapers(Money money, int manualCount) {
		Bought bought = new Bought(money, manualCount);

		LottoPapers manualLottoPapers = machine.createManualLottoPapers(enterManualLottoNumbers(manualCount));
		LottoPapers autoLottoPapers = machine.createLottoPapers(bought.buyAutoCount());
		manualLottoPapers.addAll(autoLottoPapers);

		resultView.purchasedCount(manualCount, bought.buyAutoCount());
		resultView.purchasedLottoPrint(autoLottoPapers);

		return autoLottoPapers;
	}

	private List<String> enterManualLottoNumbers(int manualCount) {
		return inputView.insertManualLottoNumbers(manualCount);
	}

	private LottoNumbers enterUserLottoNumber() {
		String userLottoNumbers = inputView.insertLottoNumber();
		return LottoNumbers.from(userLottoNumbers);
	}

	private BonusBall enterBonusBall(LottoNumbers userLottoNumbers) {
		int bonusBall = inputView.insertBonusBall();
		return BonusBall.of(bonusBall, userLottoNumbers);
	}

}