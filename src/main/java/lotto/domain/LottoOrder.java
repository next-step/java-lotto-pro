package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.LottoOrderRequest;
import lotto.domain.wrapper.LottoTicket;
import lotto.view.Machine;

public class LottoOrder {
	private List<LottoTicket> holdLottoTickets = new ArrayList<>();

	public LottoOrder() {
	}

	public List<LottoTicket> buyTickets(LottoOrderRequest order) {
		for (int i = 0; i < order.getCount(); i++) {
			this.holdLottoTickets.add(new LottoTicket());
		}
		showHoldings(this.holdLottoTickets);
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

	private void showHoldings(List<LottoTicket> holdLottoTickets) {
		Machine.showLottoTickets(holdLottoTickets);
	}
}
