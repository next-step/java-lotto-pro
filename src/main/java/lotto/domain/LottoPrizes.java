package lotto.domain;

public class LottoPrizes {

	private static final int LOTTO_5ST_PRIZE = 5_000;
	private static final int LOTTO_4ST_PRIZE = 50_000;
	private static final int LOTTO_3ST_PRIZE = 1_500_000;
	private static final int LOTTO_2ST_PRIZE = 30_000_000;
	private static final int LOTTO_1ST_PRIZE = 2_000_000_000;

	private int totalPrizeMoney;

	public LottoPrizes(LottoRanks ranks) {
		this.totalPrizeMoney = ranks.getFirstCnt() * LOTTO_1ST_PRIZE
			+ ranks.getSecondCnt() * LOTTO_2ST_PRIZE
			+ ranks.getThirdCnt() * LOTTO_3ST_PRIZE
			+ ranks.getFourthCnt() * LOTTO_4ST_PRIZE
			+ ranks.getFifthCnt() * LOTTO_5ST_PRIZE;
	}

	public int getTotalPrizeMoney() {
		return this.totalPrizeMoney;
	}
}
