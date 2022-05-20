package lotto.controller;

import java.util.List;

import lotto.domain.AutoNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.LottoPrice;
import lotto.domain.RankResult;
import lotto.dto.PrizeReport;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public void start() {
		LottoPrice lottoPrice = new LottoPrice(InputView.inputMoney());
		int count = lottoPrice.availableQuantity();
		OutputView.printPurchaseCount(count);

		LottoTickets lottoTickets = getLottoTickets(count);
		OutputView.printLottoTickets(lottoTickets.getLottTickets());

		Lotto winningLotto = Lotto.getInstanceByString(InputView.inputNumbers());
		RankResult result = lottoTickets.getResult(winningLotto);
		List<PrizeReport> report = result.getReport();
		OutputView.printPrizeResult(report);
		OutputView.printRate(result.compileStatistics(lottoPrice.expenses()));
	}

	private LottoTickets getLottoTickets(int count) {
		LottoTickets lottoTickets = new LottoTickets();
		for(int index = 0; index < count; index +=1 ) {
			lottoTickets.generate(new AutoNumbers());
		}

		return lottoTickets;
	}
}
