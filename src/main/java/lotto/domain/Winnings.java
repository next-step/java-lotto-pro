package lotto.domain;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Winnings {
	private final List<Winning> winnings;

	public Winnings(List<Winning> winnings) {
		this.winnings = unmodifiableList(winnings);
	}

	public int totalMoney() {
		return winnings.stream()
				.map(Winning::getMoney)
				.reduce(Integer::sum)
				.orElse(0);
	}

	public int countOf(Winning winning) {
		return (int) winnings.stream()
				.filter(winning::equals)
				.count();
	}
}
