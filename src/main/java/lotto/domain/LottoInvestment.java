package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.LottoOrderRequest;
import lotto.domain.wrapper.HitsByRank;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;
import lotto.domain.wrapper.Rank;
import lotto.view.Customer;
import lotto.view.Machine;

public class LottoInvestment {
	private List<LottoTicket> holdLottoTickets = new ArrayList<>();
	private LottoTicket lastWinningTicket;

	protected LottoInvestment() {
	}

	public static void start() {
		LottoInvestment lottoInvestment = new LottoInvestment();
		lottoInvestment.buyTickets(Customer.askOrder());
		lottoInvestment.findLastWinningTicket(Customer.askLastWinningTicket());
		lottoInvestment.analysisProfit();
	}

	protected void buyTickets(LottoOrderRequest order) {
		for (int i = 0; i < order.getCount(); i++) {
			this.holdLottoTickets.add(new LottoTicket());
		}
		showHoldings();
	}

	protected void findLastWinningTicket(LottoTicket lottoTicket) {
		this.lastWinningTicket = lottoTicket;
	}

	protected Money totalInvestment() {
		return new Money(holdLottoTickets.size() * LottoTicket.PRICE);
	}

	protected Money totalWinnings(HitsByRank hitsByRank) {
		int winnings = 0;

		for (Rank rank : hitsByRank.get().keySet()) {
			winnings += rank.getWinningMoney() * hitsByRank.getHitsByRank(rank);
		}
		return new Money(winnings);
	}

	protected BigDecimal analysisProfit() {
		if (holdLottoTickets.isEmpty() || lastWinningTicket == null) {
			showBeforeInvestment();
			return new Money().get();
		}
		Money investment = totalInvestment();
		HitsByRank hitsByRank = new HitsByRank();
		for (LottoTicket ticket : holdLottoTickets) {
			int matchedNumberCount = (int)ticket.getNumbers().stream()
				.filter(lastWinningTicket.getNumbers()::contains)
				.count();
			hitsByRank.hit(Rank.valueOf(matchedNumberCount, false));
		}
		BigDecimal profitPercent = totalWinnings(hitsByRank).get()
			.subtract(investment.get())
			.divide(investment.get());
		showAnalysis(hitsByRank, profitPercent);
		return profitPercent;
	}

	protected int getHoldLottoCount() {
		return this.holdLottoTickets.size();
	}

	protected List<LottoTicket> getHoldLottoTickets() {
		return this.holdLottoTickets;
	}

	private void showAnalysis(HitsByRank hitsByRank, BigDecimal profitPercent) {
		Machine.showAnalysis(hitsByRank, profitPercent);
	}

	private void showHoldings() {
		Machine.showLottoTickets(this.holdLottoTickets);
	}

	private void showBeforeInvestment() {
		Machine.showBeforeInvestment();
	}
}
