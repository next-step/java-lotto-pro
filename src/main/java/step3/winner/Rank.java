package step3.winner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
	FIRST(6, 2_000_000_000,"6개 일치 (2000000000원)- %d개\n"),
	SECOND(5, 30_000_000,"5개 일치, 보너스 볼 일치(30000000원) - %d개\n"),
	THIRD(5, 1_500_000,"5개 일치 (1500000원)- %d개\n"),
	FOUR(4, 50_000,"4개 일치 (50000원)- %d개\n"),
	FIFTH(3, 5_000,"3개 일치 (5000원)- %d개\n"),
	MISS(0, 0,"");

	private final int matchCount;
	private final int amount;
	private final String message;

	Rank(int matchNumber, int winningAmount, String message) {
		this.matchCount = matchNumber;
		this.amount = winningAmount;
		this.message = message;
	}

	public static Rank valueOf(int matchCount, boolean isBonusBall) {

		if (THIRD.matchCount == matchCount && !isBonusBall) {
			return THIRD;
		}

		if (matchCount < FIFTH.matchCount) {
			return MISS;
		}

		return Arrays.stream(values())
			.filter(s -> s.matchCount == matchCount)
			.findAny()
			.orElse(MISS);
	}

	public static Rank valueOf(int matchCount) {
		return Arrays.stream(values())
			.filter(s -> s.matchCount == matchCount)
			.findAny()
			.orElse(MISS);
	}

	public static List<Rank> reverse() {
		return Arrays.stream(values())
			.sorted(Comparator.reverseOrder())
			.filter(s-> (s != MISS))
			.collect(Collectors.toList());
	}

	public int getMatch() {
		return matchCount;
	}

	public int getAmount() {
		return amount;
	}

	public String getMessage() {
		return message;
	}
}
