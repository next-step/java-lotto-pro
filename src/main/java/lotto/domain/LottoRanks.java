package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRanks {

	private final List<Rank> ranks = new ArrayList<>();

	private int firstCnt = 0;
	private int secondCnt = 0;
	private int thirdCnt = 0;
	private int fourthCnt = 0;
	private int fifthCnt = 0;

	private LottoRanks() {
	}

	public static LottoRanks of(List<Rank> ranks) {
		LottoRanks lottoRanks = new LottoRanks();
		lottoRanks.ranks.addAll(ranks);
		for (Rank rank : ranks) {
			addCount(lottoRanks, rank);
		}
		return lottoRanks;
	}

	public static LottoRanks of(LottoNumber winningNumber, LottoNumbers numbers) {
		List<Rank> ranks = new ArrayList<>();
		for (LottoNumber number : numbers.getNumbers()) {
			Rank rank = Rank.getMatchRank(winningNumber, number);
			ranks.add(rank);
		}
		return of(ranks);
	}

	private static void addCount(LottoRanks ranks, Rank rank) {
		if (Rank.FIRST.equals(rank)) {
			ranks.firstCnt += 1;
			return;
		}
		if (Rank.SECOND.equals(rank)) {
			ranks.secondCnt += 1;
			return;
		}
		if (Rank.THIRD.equals(rank)) {
			ranks.thirdCnt += 1;
			return;
		}
		if (Rank.FOURTH.equals(rank)) {
			ranks.fourthCnt += 1;
			return;
		}
		if (Rank.FIFTH.equals(rank)) {
			ranks.fifthCnt += 1;
		}
	}

	public int getFirstCnt() {
		return firstCnt;
	}

	public int getSecondCnt() {
		return secondCnt;
	}

	public int getThirdCnt() {
		return thirdCnt;
	}

	public int getFourthCnt() {
		return fourthCnt;
	}

	public int getFifthCnt() {
		return fifthCnt;
	}

	public int getTotalPrizeMoney() {
		int prize = 0;
		for (Rank rank : ranks) {
			prize += rank.getPrize();
		}
		return prize;
	}
}
