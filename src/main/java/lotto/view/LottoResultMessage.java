package lotto.view;

import lotto.domain.quantity.Quantity;

public class LottoResultMessage {
	private final MatchRankMessage matchRankMessage;
	private final Quantity quantity;

	public LottoResultMessage(MatchRankMessage matchRankMessage, Quantity quantity) {
		this.matchRankMessage = matchRankMessage;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%s- %d개", matchRankMessage.getMessage(), quantity.getInt());
	}
}
