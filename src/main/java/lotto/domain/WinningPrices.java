package lotto.domain;

import java.util.List;

public class WinningPrices {
	private final List<WinningPrice> winningPrices;

	private WinningPrices(List<WinningPrice> winningPrices) {
		this.winningPrices = winningPrices;
	}

	public static WinningPrices from(List<WinningPrice> winningPrices) {
		return new WinningPrices(winningPrices);
	}

	public WinningPrice totalPrice() {
		return this.winningPrices.stream()
			.reduce(WinningPrice::sum)
			.orElse(new WinningPrice(0));
	}
}
