package lotto.application;

import java.math.BigDecimal;

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

	protected LottoInvestment() {
		this.lottoOrder = new LottoOrder();
		this.lottoAnalysis = new LottoAnalysis();
	}

	public static void start() {
		LottoInvestment lottoInvestment = new LottoInvestment();
		lottoInvestment.buyTicket();
		lottoInvestment.findLastWinningTicket(Customer.askLastWinningTicket());
		lottoInvestment.analysisProfit();
	}

	protected void buyTicket() {
		Machine.showLottoTickets(this.lottoOrder.buyTickets(Customer.askOrder()));
	}

	protected void findLastWinningTicket(LottoTicket lottoTicket) {
		this.lottoAnalysis.setLastWinningTicket(lottoTicket);
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

	private void showAnalysis(HitsByRank hitsByRank, BigDecimal profitPercent) {
		Machine.showAnalysis(hitsByRank, profitPercent);
	}

	private void showBeforeInvestment() {
		Machine.showBeforeInvestment();
	}
}
