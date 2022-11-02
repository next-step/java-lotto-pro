package lotto.view;

import lotto.domain.amount.MatchRank;
import lotto.domain.quantity.Quantity;
import lotto.domain.match.count.MatchCount;

public class LottoResultMessage {
	private final MatchCount matchCount;
	private final Quantity quantity;

	public LottoResultMessage(MatchCount matchCount, Quantity quantity) {
		this.matchCount = matchCount;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		int matchCountInt = this.matchCount.getInt();
		long winningPriceLong = MatchRank.valueOfMatchCount(matchCountInt).getWinningPrice();
		int quantity = this.quantity.getInt();

		return String.format("%d개 일치 (%d원)- %d", matchCountInt, winningPriceLong, quantity);
	}
}
