package lotto;

public class MatchPoint {

	private static final int LOTTO_4ST_PRIZE = 5000;
	private static final int LOTTO_3ST_PRIZE = 50000;
	private static final int LOTTO_2ST_PRIZE = 1500000;
	private static final int LOTTO_1ST_PRIZE = 2000000000;
	private static final int LOTTO_4ST_MATCH_CNT = 3;
	private static final int LOTTO_3ST_MATCH_CNT = 4;
	private static final int LOTTO_2ST_MATCH_CNT = 5;
	private static final int LOTTO_1ST_MATCH_CNT = 6;

	private int first = 0;
	private int second = 0;
	private int third = 0;
	private int fourth = 0;

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
	}

	public int getFourth() {
		return fourth;
	}

	public void addPoint(int count) {
		if (count == LOTTO_4ST_MATCH_CNT) {
			fourth += 1;
			return;
		}
		if (count == LOTTO_3ST_MATCH_CNT) {
			third += 1;
			return;
		}
		if (count == LOTTO_2ST_MATCH_CNT) {
			second += 1;
			return;
		}
		if (count == LOTTO_1ST_MATCH_CNT) {
			first += 1;
		}
	}

	public int getPrize() {
		return first * LOTTO_1ST_PRIZE
			+ second * LOTTO_2ST_PRIZE
			+ third * LOTTO_3ST_PRIZE
			+ fourth * LOTTO_4ST_PRIZE;
	}

}
