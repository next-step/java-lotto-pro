package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDomain {

	private static final int LOTTO_PRICE = 1000;
	private static final int LOTTO_NUMBER_MINIMUM = 1;
	private static final int LOTTO_NUMBER_MAXIMUM = 45;
	private static final int LOTTO_NUMBER_SIZE = 6;
	private static final int LOTTO_4ST_MATCH_CNT = 3;
	private static final int LOTTO_3ST_MATCH_CNT = 4;
	private static final int LOTTO_2ST_MATCH_CNT = 5;
	private static final int LOTTO_1ST_MATCH_CNT = 6;
	private static final int LOTTO_4ST_PRIZE = 5000;
	private static final int LOTTO_3ST_PRIZE = 50000;
	private static final int LOTTO_2ST_PRIZE = 1500000;
	private static final int LOTTO_1ST_PRIZE = 2000000000;

	private final List<Integer> candidates;

	public LottoDomain() {
		this.candidates = new ArrayList<>();
		for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
			this.candidates.add(i);
		}
	}

	public int getLottoCountByMoney(int money) {
		return money / LOTTO_PRICE;
	}

	public List<List<Integer>> getLottoNumbersByCount(int count) {
		List<List<Integer>> numberList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			numberList.add(generateLottoNumber());
		}
		return numberList;
	}

	private List<Integer> generateLottoNumber() {
		Collections.shuffle(candidates);
		List<Integer> numbers = candidates.subList(0, LOTTO_NUMBER_SIZE);
		Collections.sort(numbers);
		return numbers;
	}

	public int getMatchCount(List<Integer> answerNumbers, List<Integer> numbers) {
		int matchCount = 0;
		for (Integer answerNumber : answerNumbers) {
			matchCount += isContainNumber(answerNumber, numbers);
		}
		return matchCount;
	}

	private int isContainNumber(int a, List<Integer> numbers) {
		if (numbers.contains(a)) {
			return 1;
		}
		return 0;
	}

	public double getProfit(int money, List<Integer> matchCounts) {
		int prize = 0;
		for (int matchCount : matchCounts) {
			prize += getPrizeByMatchCount(matchCount);
		}
		double profit = (double)prize / money;
		return Math.floor(profit * 100) / 100D;
	}

	private int getPrizeByMatchCount(int matchCount) {
		if (matchCount == LOTTO_4ST_MATCH_CNT) {
			return LOTTO_4ST_PRIZE;
		}
		if (matchCount == LOTTO_3ST_MATCH_CNT) {
			return LOTTO_3ST_PRIZE;
		}
		if (matchCount == LOTTO_2ST_MATCH_CNT) {
			return LOTTO_2ST_PRIZE;
		}
		if (matchCount == LOTTO_1ST_MATCH_CNT) {
			return LOTTO_1ST_PRIZE;
		}
		return 0;
	}
}
