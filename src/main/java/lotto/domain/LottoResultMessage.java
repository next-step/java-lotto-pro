package lotto.domain;

public class LottoResultMessage {
	private final MatchCount matchCount;
	private final int quantity;
	private final WinningPrice winningPrice;

	public LottoResultMessage(MatchCount matchCount, int quantity, WinningPrice winningPrice) {
		this.matchCount = matchCount;
		this.quantity = quantity;
		this.winningPrice = winningPrice;
	}

	@Override
	public String toString() {
		return String.format("%d개 일치 (%d원)- %d", this.matchCount.getInt(), this.winningPrice.getLong(), this.quantity);
	}
}
