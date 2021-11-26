package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.HitsByMatchedNumberCount;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.LottoWinningMoney;
import lotto.domain.wrapper.Money;
import lotto.view.Customer;
import lotto.view.Machine;

public class LottoInvestment {
	private List<LottoTicket> holdLottoTickets = new ArrayList<>();
	private LottoTicket lastWinningTicket;

	public LottoInvestment() {
	}

	public static void start() {
		LottoInvestment lottoInvestment = new LottoInvestment();
		lottoInvestment.buyTickets(Customer.askOrder());
		lottoInvestment.findLastWinningTicket(Customer.askLastWinningTicket());
		lottoInvestment.analysisProfit();
	}

	protected void buyTickets(LottoOrder order) {
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

	protected Money totalWinnings(HitsByMatchedNumberCount hitsByMatchedNumberCount) {
		int winnings = 0;
		for (Integer matchedNumberCount : hitsByMatchedNumberCount.get().keySet()) {
			winnings +=
				LottoWinningMoney.getMoneyByMatchedNumberCount(matchedNumberCount) * hitsByMatchedNumberCount.get()
					.get(matchedNumberCount);
		}
		return new Money(winnings);
	}

	protected double analysisProfit() {
		if (holdLottoTickets.isEmpty() || lastWinningTicket == null) {
			showBeforeInvestment();
			return new Money().get();
		}
		Money investment = totalInvestment();
		HitsByMatchedNumberCount hitsByMatchedNumberCount = new HitsByMatchedNumberCount();
		for (LottoTicket ticket : holdLottoTickets) {
			int matchedNumberCount = (int)ticket.getNumbers().stream()
				.filter(lastWinningTicket.getNumbers()::contains)
				.count();
			hitsByMatchedNumberCount.hit(matchedNumberCount);
		}
		Money winnings = totalWinnings(hitsByMatchedNumberCount);
		showAnalysis(hitsByMatchedNumberCount, investment, winnings);
		return (winnings.get() - investment.get()) / investment.get();
	}

	protected int getHoldLottoCount() {
		return this.holdLottoTickets.size();
	}

	protected List<LottoTicket> getHoldLottoTickets() {
		return this.holdLottoTickets;
	}

	private void showAnalysis(HitsByMatchedNumberCount hitsByMatchedNumberCount, Money investment, Money winnings) {
		Machine.showAnalysis(hitsByMatchedNumberCount, investment, winnings);
	}

	private void showHoldings() {
		Machine.showLottoTickets(this.holdLottoTickets);
	}

	private void showBeforeInvestment() {
		Machine.showBeforeInvestment();
	}
}
