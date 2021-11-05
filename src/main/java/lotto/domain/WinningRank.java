package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public enum WinningRank {
	FIRST_PLACE(6, 2_000_000_000),
	SECOND_PLACE(5, 30_000_000),
	THIRD_PLACE(5, 1_500_000),
	FOURTH_PLACE(4, 50_000),
	FIFTH_PLACE(3, 5_000),
	NO_PLACE(0, 0);

	private final int winningNumberCount;
	private final int prizeMoney;

	WinningRank(int winningNumberCount, int prizeMoney) {
		this.winningNumberCount = winningNumberCount;
		this.prizeMoney = prizeMoney;
	}

	public static WinningRank valueOf(int countWinningNumbers, boolean hasBonusNumber) {
		if (isSecondPlace(countWinningNumbers, hasBonusNumber)) {
			return SECOND_PLACE;
		}

		return decideWinningRank(countWinningNumbers);
	}

	private static boolean isSecondPlace(int countWinningNumbers, boolean hasBonusNumber) {
		return countWinningNumbers == SECOND_PLACE.getWinningNumberCount() && hasBonusNumber;
	}

	private static WinningRank decideWinningRank(int winningNumberCount) {
		return Arrays.stream(WinningRank.values())
					 .filter(rank -> rank.getWinningNumberCount() == winningNumberCount)
					 .findAny()
					 .orElse(NO_PLACE);
	}

	public static List<WinningRank> getPlaceRanks() {
		return Stream.of(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE)
					 .sorted(Comparator.comparing(WinningRank::getPrizeMoney))
					 .collect(toList());
	}

	public boolean isSecondPlace() {
		return this.equals(SECOND_PLACE);
	}

	public int getWinningNumberCount() {
		return this.winningNumberCount;
	}

	public int getPrizeMoney() {
		return this.prizeMoney;
	}
}
