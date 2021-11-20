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
		buyTickets();
		findLastWinningTicket();
		analysis();
	}

	private void buyTickets() {
		LottoOrder order = Customer.askOrder();
		for (int i = 0; i < order.getCount(); i++) {
			this.holdLottoTickets.add(new LottoTicket());
		}
		showHoldings();
	}

	private void showHoldings() {
		Machine.showLottoTickets(this.holdLottoTickets);
	}

	private void findLastWinningTicket() {
		this.lastWinningTicket = Customer.askLastWinningTicket();
	}

	private Money totalInvestment() {
		return new Money(holdLottoTickets.size() * LottoTicket.PRICE);
	}

	private Money totalWinnings(HitsByMatchedNumberCount hitsByMatchedNumberCount) {
		int winnings = 0;
		for (Integer matchedNumberCount : hitsByMatchedNumberCount.get().keySet()) {
			winnings +=
				LottoWinningMoney.getMoneyByMatchedNumberCount(matchedNumberCount) * hitsByMatchedNumberCount.get()
					.get(matchedNumberCount);
		}
		return new Money(winnings);
	}

	private void analysis() {
		Money investment = totalInvestment();
		HitsByMatchedNumberCount hitsByMatchedNumberCount = new HitsByMatchedNumberCount();
		for (LottoTicket ticket : holdLottoTickets) {
			int matchedNumberCount = (int)ticket.getNumbers().stream()
				.filter(lastWinningTicket.getNumbers()::contains)
				.count();
			hitsByMatchedNumberCount.hit(matchedNumberCount);
		}
		Money winnings = totalWinnings(hitsByMatchedNumberCount);
		Machine.showAnalysis(hitsByMatchedNumberCount, investment, winnings);
	}
}
