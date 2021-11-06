package lotto.domain;

import java.util.List;

public class LottoRanks {

	private int firstCnt = 0;
	private int secondCnt = 0;
	private int thirdCnt = 0;
	private int fourthCnt = 0;

	public LottoRanks(List<LottoRank> list) {
		for (LottoRank lottoRank : list) {
			setCount(lottoRank);
		}
	}

	public LottoRanks(LottoNumber winningNumber, LottoNumbers numbers) {
		for (LottoNumber number : numbers.getNumbers()) {
			LottoRank rank = new LottoRank(winningNumber, number);
			setCount(rank);
		}
	}

	private void setCount(LottoRank lottoRank) {
		if (lottoRank.isFirst()) {
			firstCnt += 1;
			return;
		}
		if (lottoRank.isSecond()) {
			secondCnt += 1;
			return;
		}
		if (lottoRank.isThird()) {
			thirdCnt += 1;
			return;
		}
		if (lottoRank.isFourth()) {
			fourthCnt += 1;
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
}
