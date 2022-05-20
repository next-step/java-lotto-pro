package lotto.dto;

import java.util.Objects;

import lotto.domain.Rank;

public class PrizeReport implements Comparable<PrizeReport> {
	int matchCount;
	int money;
	int result;
	boolean containBonusNumber;

	public PrizeReport(Rank rank, int result, boolean containBonusNumber) {
		this.matchCount = rank.getMatchCount();
		this.money = rank.getPrizeMoney();
		this.result = result;
		this.containBonusNumber = containBonusNumber;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}

	public int getResult() {
		return result;
	}

	public boolean isContainBonusNumber() {
		return containBonusNumber;
	}

	@Override
	public int compareTo(PrizeReport o) {
		return Integer.compare(matchCount, o.matchCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PrizeReport that = (PrizeReport)o;
		return matchCount == that.matchCount && money == that.money && result == that.result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matchCount, money, result);
	}
}
