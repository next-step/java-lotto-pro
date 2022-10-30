package lotto.domain;

public class NumberMatchResultMessageStrategy implements ResultMessageStrategy {
	private final int matchCount;
	private final long matchPrice;

	public NumberMatchResultMessageStrategy(int matchCount, long matchPrice) {
		this.matchCount = matchCount;
		this.matchPrice = matchPrice;
	}

	@Override
	public String resultMessage(int quantity) {
		return String.format("%d개 일치 (%d원)- %d개", matchCount, matchPrice, quantity);
	}
}
