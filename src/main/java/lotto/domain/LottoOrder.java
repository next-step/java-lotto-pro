package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.LottoOrderCount;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;

public class LottoOrder {
	private List<LottoTicket> holdLottoTickets = new ArrayList<>();
	private LottoOrderCount manualLottoOrderCount = new LottoOrderCount();

	public LottoOrder(LottoOrderCount order) {
		buyTickets(order);
	}

	public List<LottoTicket> buyTickets(LottoOrderCount order) {
		for (int i = 0; i < order.get(); i++) {
			this.holdLottoTickets.add(new LottoTicket());
		}
		return this.holdLottoTickets;
	}

	public List<LottoTicket> buyManualTickets(List<LottoTicket> tickets) {
		this.holdLottoTickets.addAll(tickets);
		this.manualLottoOrderCount = new LottoOrderCount(tickets.size());
		return this.holdLottoTickets;
	}

	public int holdManualCount() {
		return this.manualLottoOrderCount.get();
	}

	public int holdCount() {
		return this.holdLottoTickets.size();
	}

	public List<LottoTicket> holdings() {
		return this.holdLottoTickets;
	}

	public Money totalInvestment() {
		return new Money(this.holdLottoTickets.size() * LottoTicket.PRICE);
	}
}
