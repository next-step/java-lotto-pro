package lotto.domain;

public class LottoResultMessage {
	private final MatchCount matchCount;
	private final int quantity;

	public LottoResultMessage(MatchCount matchCount, int quantity) {
		this.matchCount = matchCount;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		int matchCountInt = this.matchCount.getInt();
		long winningPriceLong = this.matchCount.winningPrice().getLong();

		return String.format("%d개 일치 (%d원)- %d", matchCountInt, winningPriceLong,
			this.quantity);
	}
}
