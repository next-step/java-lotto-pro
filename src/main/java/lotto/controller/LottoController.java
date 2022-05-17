package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.dto.PrizeReport;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public void start() {
		Money money = new Money(InputView.inputMoney());
		int count = money.availableQuantity();
		OutputView.printPurchaseCount(count);

		LottoTickets lottoTickets = getLottoTickets(count);
		OutputView.printLottoTickets(lottoTickets.getLottTickets());

		Lotto winningLotto = Lotto.getInstanceByString(InputView.inputNumbers());
		RankResult result = lottoTickets.getResult(winningLotto);
		List<PrizeReport> report = result.getReport();
		OutputView.printPrizeResult(report);
		OutputView.printRate(result.compileStatistics(money.expenses()));
	}

	private LottoTickets getLottoTickets(int count) {
		LottoTickets lottoTickets = new LottoTickets();
		for(int index = 0; index < count; index +=1 ) {
			lottoTickets.automaticallyGenerate();
		}

		return lottoTickets;
	}
}
