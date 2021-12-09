package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.LottoOrderRequest;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;

public class LottoOrder {
	private List<LottoTicket> holdLottoTickets = new ArrayList<>();

	public LottoOrder(LottoOrderRequest order) {
		buyTickets(order);
	}

	public List<LottoTicket> buyTickets(LottoOrderRequest order) {
		for (int i = 0; i < order.getCount(); i++) {
			this.holdLottoTickets.add(new LottoTicket());
		}
		return this.holdLottoTickets;
	}

	public int holdCount() {
		return this.holdLottoTickets.size();
	}

	public boolean notYetOrdered() {
		return this.holdLottoTickets.isEmpty();
	}

	public List<LottoTicket> holdings() {
		return this.holdLottoTickets;
	}

	public Money totalInvestment() {
		return new Money(this.holdLottoTickets.size() * LottoTicket.PRICE);
	}
}
