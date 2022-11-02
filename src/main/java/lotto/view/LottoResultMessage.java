package lotto.view;

import lotto.domain.lotto.MatchRank;
import lotto.domain.quantity.Quantity;

public class LottoResultMessage {
	private final MatchRank matchRank;
	private final Quantity quantity;

	public LottoResultMessage(MatchRank matchRank, Quantity quantity) {
		this.matchRank = matchRank;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		int matchCount = this.matchRank.getMatchCount();
		long winningPrice = this.matchRank.getWinningPrice();
		int quantity = this.quantity.getInt();

		return String.format("%d개 일치 (%d원)- %d", matchCount, winningPrice, quantity);
	}
}
