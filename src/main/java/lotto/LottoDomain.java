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

	public double getProfit(int money, MatchPoint pointVo) {
		int prize = pointVo.getPrize();
		double profit = (double)prize / money;
		return Math.floor(profit * 100) / 100D;
	}

	public MatchPoint calculatePoint(List<Integer> answerNumbers, List<List<Integer>> numbers) {
		List<Integer> matchCounts = new ArrayList<>();
		for (List<Integer> number : numbers) {
			matchCounts.add(getMatchCount(answerNumbers, number));
		}
		return calculatePointByMatchCnt(matchCounts);
	}

	private MatchPoint calculatePointByMatchCnt(List<Integer> counts) {
		MatchPoint vo = new MatchPoint();
		for (int count : counts) {
			vo.addPoint(count);
		}
		return vo;
	}

	private int getMatchCount(List<Integer> answerNumbers, List<Integer> numbers) {
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

	private List<Integer> generateLottoNumber() {
		Collections.shuffle(candidates);
		List<Integer> numbers = new ArrayList<>(candidates.subList(0, LOTTO_NUMBER_SIZE));
		Collections.sort(numbers);
		return numbers;
	}
}
