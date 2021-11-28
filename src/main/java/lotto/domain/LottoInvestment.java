package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

import lotto.domain.wrapper.HitsByRank;
import lotto.domain.wrapper.LottoOrderRequest;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;
import lotto.domain.wrapper.Rank;
import lotto.view.Customer;
import lotto.view.Machine;

public class LottoInvestment {
	private LottoOrder lottoOrder;
	private LottoTicket lastWinningTicket;

	public LottoInvestment() {
		this.lottoOrder = new LottoOrder();
	}

	public void start() {
		buyTicket();
		findLastWinningTicket(Customer.askLastWinningTicket());
		analysisProfit();
	}

	protected List<LottoTicket> holdings() {
		return lottoOrder.holdings();
	}

	protected void buyTicket(LottoOrderRequest request) {
		Machine.showLottoTickets(this.lottoOrder.buyTickets(request));
	}

	protected void buyTicket() {
		Machine.showLottoTickets(this.lottoOrder.buyTickets(Customer.askOrder()));
	}

	protected void findLastWinningTicket(LottoTicket lottoTicket) {
		this.lastWinningTicket = lottoTicket;
	}

	protected Money totalInvestment() {
		return new Money(this.lottoOrder.holdCount() * LottoTicket.PRICE);
	}

	protected Money totalWinnings(HitsByRank hitsByRank) {
		int winnings = 0;

		for (Rank rank : hitsByRank.get().keySet()) {
			winnings += rank.getWinningMoney() * hitsByRank.getHitsByRank(rank);
		}
		return new Money(winnings);
	}

	protected BigDecimal analysisProfit() {
		if (this.lottoOrder.notYetOrdered() || this.lastWinningTicket == null) {
			showBeforeInvestment();
			return new Money().get();
		}
		Money investment = totalInvestment();
		HitsByRank hitsByRank = new HitsByRank();
		for (LottoTicket ticket : this.lottoOrder.holdings()) {
			int matchedNumberCount = (int)ticket.getNumbers().stream()
				.filter(this.lastWinningTicket.getNumbers()::contains)
				.count();
			hitsByRank.hit(Rank.valueOf(matchedNumberCount, false));
		}
		BigDecimal profitPercent = totalWinnings(hitsByRank).get()
			.subtract(investment.get())
			.divide(investment.get());
		showAnalysis(hitsByRank, profitPercent);
		return profitPercent;
	}

	private void showAnalysis(HitsByRank hitsByRank, BigDecimal profitPercent) {
		Machine.showAnalysis(hitsByRank, profitPercent);
	}

	private void showBeforeInvestment() {
		Machine.showBeforeInvestment();
	}
}
