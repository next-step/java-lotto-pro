package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.LottoTicket;
import lotto.view.Customer;
import lotto.view.Machine;

public class LottoInvest {
	private List<LottoTicket> holdLottoTickets = new ArrayList<>();
	private LottoTicket lastWinningTicket;

	public LottoInvest() {
		buyTickets();
		showHoldings();
		findLastWinningTicket();
	}

	private void buyTickets() {
		LottoOrder order = Customer.askOrder();
		for (int i = 0; i < order.getCount(); i++) {
			this.holdLottoTickets.add(new LottoTicket());
		}
	}

	private void showHoldings() {
		Machine.showLottoTickets(this.holdLottoTickets);
	}

	private void findLastWinningTicket() {
		this.lastWinningTicket = Customer.askLastWinningTicket();
	}
}
