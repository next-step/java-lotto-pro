package lotto.domain;

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
		long winningPriceLong = this.matchCount.winningPrice().getLong();
		int quantity = this.quantity.getInt();

		return String.format("%d개 일치 (%d원)- %d", matchCountInt, winningPriceLong, quantity);
	}
}
