package lotto.dto;

public class PrizeReport {
	int matchCount;
	int money;
	int result;

	public PrizeReport(int matchCount, int money, int result) {
		this.matchCount = matchCount;
		this.money = money;
		this.result = result;
	}
}
