package lotto.dto;

public class PrizeReport implements Comparable<PrizeReport> {
	int matchCount;
	int money;
	int result;

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
