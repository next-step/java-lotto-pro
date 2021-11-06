package lotto.model;

public enum LottoResult {
	NOT_MATCH(0), MATCH_THREE(5000), MATCH_FOUR(50000), MATCH_FIVE(1500000), MATCH_SIX(2000000000);

	private final int reward;
	LottoResult(int reward) {
		this.reward = reward;
	}

	public int getReward() {
		return reward;
	}

	public static LottoResult getResult(int match) {
		if (match == 6) {
			return MATCH_SIX;
		}
		if (match == 5) {
			return MATCH_FIVE;
		}
		if (match == 4) {
			return MATCH_FOUR;
		}
		if (match == 3) {
			return MATCH_THREE;
		}
		return NOT_MATCH;
	}
}
