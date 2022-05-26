package lotto.controller;

import java.util.List;

import lotto.domain.AutoNumbers;
import lotto.domain.Ledger;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTickets;
import lotto.domain.Number;
import lotto.domain.RankResult;
import lotto.dto.PrizeReport;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PurchaseHistory;

public class LottoController {
	public void start() {
		LottoPrice lottoPrice = new LottoPrice(InputView.inputMoney());
		int manualCount = InputView.inputNumberOfAttempts();
		List<List<String>> manualLottoList = InputView.inputManualNumbers(manualCount);

		Ledger ledger = new Ledger(lottoPrice, manualLottoList);
		LottoMachine lottoMachine = new LottoMachine(new AutoNumbers());

		LottoTickets lottoTickets = getLottoTickets(ledger, lottoMachine);
		RankResult result = getRankResult(lottoTickets, lottoMachine);

		reportLottoResult(lottoPrice, result);
	}

	private LottoTickets getLottoTickets(Ledger ledger, LottoMachine lottoMachine) {
		PurchaseHistory purchaseHistory = ledger.getPurchaseHistory();

		LottoTickets lottoTickets = lottoMachine.generateByManual(ledger);
		LottoTickets autoLottoTickets = lottoMachine.generateByAuto(purchaseHistory.getAutoCount());
		lottoTickets.sum(autoLottoTickets);

		OutputView.printPurchaseCount(purchaseHistory);
		OutputView.printLottoTickets(autoLottoTickets.getLottTickets());

		return lottoTickets;
	}

	private RankResult getRankResult(LottoTickets lottoTickets, LottoMachine lottoMachine) {
		Lotto winningLotto = lottoMachine.createLottoInstance(InputView.inputWinningNumbers());
		Number number = new Number(InputView.inputBonusNumber());

		return lottoTickets.getResult(winningLotto, number);
	}

	private void reportLottoResult(LottoPrice lottoPrice, RankResult result) {
		List<PrizeReport> report = result.getReport();
		OutputView.printPrizeResult(report);
		OutputView.printRate(result.compileStatistics(lottoPrice.expenses()));
	}
}
