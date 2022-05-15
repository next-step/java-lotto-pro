package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.dto.PrizeReport;

public class RankResult {
	private int firstCount = 0;
	private int secondCount = 0;
	private int thirdCount = 0;
	private int fourthCount = 0;

	public void setUp(Rank rank) {
		if(rank.isFirst()) {
			firstCount += 1;
			return;
		}

		if(rank.isSecond()) {
			secondCount += 1;
			return;
		}

		if(rank.isThird()) {
			thirdCount += 1;
			return;
		}

		if(rank.isFourth()) {
			fourthCount += 1;
			return;
		}
	}

	public List<PrizeReport> getReport() {
		List<PrizeReport> prizes = new ArrayList<>();

		prizes.add(new PrizeReport(Rank.FOURTH.getMatchCount(), Rank.FOURTH.getPrizeMoney(), fourthCount));
		prizes.add(new PrizeReport(Rank.THIRD.getMatchCount(), Rank.THIRD.getPrizeMoney(), thirdCount));
		prizes.add(new PrizeReport(Rank.SECOND.getMatchCount(), Rank.SECOND.getPrizeMoney(), secondCount));
		prizes.add(new PrizeReport(Rank.FIRST.getMatchCount(), Rank.FIRST.getPrizeMoney(), firstCount));

		return prizes;
	}
}
