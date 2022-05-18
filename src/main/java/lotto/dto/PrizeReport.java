package lotto.dto;

import lotto.domain.Rank;

public class PrizeReport implements Comparable<PrizeReport> {
	int matchCount;
	int money;
	int result;

	public PrizeReport(Rank rank, int result) {
		this.matchCount = rank.getMatchCount();
		this.money = rank.getPrizeMoney();
		this.result = result;
	}

	public PrizeReport(int matchCount, int money, int result) {
		this.matchCount = matchCount;
		this.money = money;
		this.result = result;
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

	@Override
	public int compareTo(PrizeReport o) {
		return Integer.compare(matchCount, o.matchCount);
	}
}
