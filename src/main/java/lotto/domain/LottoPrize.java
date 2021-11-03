package lotto.domain;

import java.util.List;

public class LottoPrize {

	private static final int LOTTO_4ST_MATCH_CNT = 3;
	private static final int LOTTO_3ST_MATCH_CNT = 4;
	private static final int LOTTO_2ST_MATCH_CNT = 5;
	private static final int LOTTO_1ST_MATCH_CNT = 6;
	private static final int LOTTO_4ST_PRIZE = 5000;
	private static final int LOTTO_3ST_PRIZE = 50000;
	private static final int LOTTO_2ST_PRIZE = 1500000;
	private static final int LOTTO_1ST_PRIZE = 2000000000;

	private int cnt1St = 0;
	private int cnt2St = 0;
	private int cnt3St = 0;
	private int cnt4St = 0;

	public LottoPrize(LottoNumber answer, List<LottoNumber> numbers) {
		for (LottoNumber number : numbers) {
			int matchCnt = answer.getMatchCount(number);
			addMatchCount(matchCnt);
		}
	}

	public LottoPrize(int cnt1St, int cnt2St, int cnt3St, int cnt4St) {
		this.cnt1St = cnt1St;
		this.cnt2St = cnt2St;
		this.cnt3St = cnt3St;
		this.cnt4St = cnt4St;
	}

	public int getCnt1St() {
		return cnt1St;
	}

	public int getCnt2St() {
		return cnt2St;
	}

	public int getCnt3St() {
		return cnt3St;
	}

	public int getCnt4St() {
		return cnt4St;
	}

	private void addMatchCount(int matchCount) {
		if (matchCount == LOTTO_4ST_MATCH_CNT) {
			cnt4St += 1;
			return;
		}
		if (matchCount == LOTTO_3ST_MATCH_CNT) {
			cnt3St += 1;
			return;
		}
		if (matchCount == LOTTO_2ST_MATCH_CNT) {
			cnt2St += 1;
			return;
		}
		if (matchCount == LOTTO_1ST_MATCH_CNT) {
			cnt1St += 1;
		}
	}

	public int getPrize() {
		return cnt1St * LOTTO_1ST_PRIZE
			+ cnt2St * LOTTO_2ST_PRIZE
			+ cnt3St * LOTTO_3ST_PRIZE
			+ cnt4St * LOTTO_4ST_PRIZE;
	}

}
