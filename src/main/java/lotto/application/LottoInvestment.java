package lotto.application;

import java.math.BigDecimal;
import java.util.List;

import lotto.domain.LottoAnalysis;
import lotto.domain.LottoOrder;
import lotto.domain.wrapper.AnalysisResult;
import lotto.domain.wrapper.HitsByRank;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;
import lotto.view.Customer;
import lotto.view.Machine;

public class LottoInvestment {
	private LottoOrder lottoOrder;
	private LottoAnalysis lottoAnalysis;

	protected LottoInvestment(LottoOrder lottoOrder, LottoAnalysis lottoAnalysis) {
		this.lottoOrder = lottoOrder;
		this.lottoAnalysis = lottoAnalysis;
	}

	public static void start() {
		LottoOrder lottoOrder = new LottoOrder(Customer.askOrder());
		lottoOrder.buyManualTickets(Customer.askManualLottoTickets(Customer.askManualOrderCount()));
		showHoldLottoTickets(lottoOrder.holdings(), lottoOrder.holdManualCount());
		LottoAnalysis lottoAnalysis = new LottoAnalysis(Customer.askLastWinningTicket(), Customer.askBonusNumber());
		LottoInvestment lottoInvestment = new LottoInvestment(lottoOrder, lottoAnalysis);
		lottoInvestment.analysisProfit();
	}

	protected static void showHoldLottoTickets(List<LottoTicket> lottoTickets, int manualCount) {
		Machine.showLottoTickets(lottoTickets, manualCount);
	}

	private static void showAnalysis(HitsByRank hitsByRank, BigDecimal profitPercent) {
		Machine.showAnalysis(hitsByRank, profitPercent);
	}

	private static void showBeforeInvestment() {
		Machine.showBeforeInvestment();
	}

	protected BigDecimal analysisProfit() {
		if (this.lottoOrder.notYetOrdered() || !lottoAnalysis.hasLastWinningTicket()) {
			showBeforeInvestment();
			return new Money().get();
		}
		AnalysisResult result = lottoAnalysis.analysis(lottoOrder.totalInvestment() ,lottoOrder.holdings());
		showAnalysis(result.getHitsByRank(), result.getProfitPercent());
		return result.getProfitPercent();
	}
}
