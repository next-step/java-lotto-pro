package lotto.domain;

public class LottoPrizes {

	private static final int LOTTO_4ST_PRIZE = 5000;
	private static final int LOTTO_3ST_PRIZE = 50000;
	private static final int LOTTO_2ST_PRIZE = 1500000;
	private static final int LOTTO_1ST_PRIZE = 2000000000;

	private int totalPrizeMoney;

	public LottoPrizes(LottoRanks ranks) {
		this.totalPrizeMoney = ranks.getFirstCnt() * LOTTO_1ST_PRIZE
			+ ranks.getSecondCnt() * LOTTO_2ST_PRIZE
			+ ranks.getThirdCnt() * LOTTO_3ST_PRIZE
			+ ranks.getFourthCnt() * LOTTO_4ST_PRIZE;
	}

	public int getTotalPrizeMoney() {
		return this.totalPrizeMoney;
	}
}
