package lotto.controller;

import java.util.List;

import lotto.domain.AutoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTickets;
import lotto.domain.Number;
import lotto.domain.RankResult;
import lotto.dto.PrizeReport;
import lotto.dto.StringLottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public void start() {
		LottoPrice lottoPrice = new LottoPrice(InputView.inputMoney());
		int manualCount = InputView.inputNumberOfAttempts();

		LottoTickets lottoTickets = getLottoTicketsByManual(lottoPrice, manualCount);

		int autoCount = lottoPrice.availableQuantity() - manualCount;
		OutputView.printPurchaseCount(manualCount, autoCount);

		lottoTickets.sum(automaticallyBuyLotto(autoCount));

		Lotto winningLotto = Lotto.getInstanceByString(InputView.inputWinningNumbers());
		Number number = new Number(InputView.inputBonusNumber());
		RankResult result = lottoTickets.getResult(winningLotto, number);

		reportLottoResult(lottoPrice, result);
	}

	private LottoTickets automaticallyBuyLotto(int autoCount) {
		LottoTickets lottoTickets = getLottoTicketsByAuto(autoCount);
		OutputView.printLottoTickets(lottoTickets.getLottTickets());

		return lottoTickets;
	}

	private LottoTickets getLottoTicketsByAuto(int count) {
		LottoMachine lottoMachine = new LottoMachine(new AutoNumbers());

		return lottoMachine.generate(count);
	}

	private LottoTickets getLottoTicketsByManual(LottoPrice lottoPrice, int manualCount) {
		lottoPrice.validateOrder(manualCount);

		StringLottoTickets lottoTickets = InputView.inputManualNumbers(manualCount);
		List<Lotto> lottoList = lottoTickets.convertToLottoList();

		return new LottoTickets(lottoList);
	}

	private void reportLottoResult(LottoPrice lottoPrice, RankResult result) {
		List<PrizeReport> report = result.getReport();
		OutputView.printPrizeResult(report);
		OutputView.printRate(result.compileStatistics(lottoPrice.expenses()));
	}
}
