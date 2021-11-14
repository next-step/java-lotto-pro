package step3.machine;

import static step3.machine.create.LottoMachineType.*;

import java.math.BigDecimal;
import java.util.List;

import step3.Money;
import step3.lotto.BonusBall;
import step3.lotto.LottoNumbers;
import step3.lotto.LottoPapers;
import step3.machine.create.Machine;
import step3.view.InputView;
import step3.view.ResultView;
import step3.winner.Winning;
import step3.winner.WinningMoney;
import step3.winner.WinningResult;
import step3.winner.WinningResultMap;

public class LottoMachineFacade {

	private final InputView inputView;
	private final ResultView resultView;

	public LottoMachineFacade(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void LottoMachineExecute() {
			Money money = enterMoney();
			int manualCount = enterManualCount();
			LottoPapers lottoPapers = createLottoPapers(money, manualCount);

			LottoNumbers winningLottoNumbers = enterUserLottoNumber();
			BonusBall bonusBall = enterBonusBall(winningLottoNumbers);

			Winning winning = new Winning(winningLottoNumbers, bonusBall);
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

		Machine manual = lottoFactory(MANUAL);
		Machine auto = lottoFactory(AUTO);

		LottoPapers manualLottoPapers = manual.createLotto(enterManualLottoNumbers(manualCount));
		LottoPapers autoLottoPapers = auto.createLotto(bought.buyAutoCount());

		manualLottoPapers.addAll(autoLottoPapers);

		resultView.purchasedCount(manualCount, bought.buyAutoCount());
		resultView.purchasedLottoPrint(autoLottoPapers);

		return manualLottoPapers;
	}

	private List<String> enterManualLottoNumbers(int manualCount) {
		return inputView.insertManualLottoNumbers(manualCount);
	}

	private LottoNumbers enterUserLottoNumber() {
		String winningLottoNumbers = inputView.insertLottoNumber();
		return LottoNumbers.from(winningLottoNumbers);
	}

	private BonusBall enterBonusBall(LottoNumbers winningLottoNumbers) {
		int bonusBall = inputView.insertBonusBall();
		return new BonusBall(bonusBall);
	}

}