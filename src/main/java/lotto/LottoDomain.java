package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDomain {

	private static final int LOTTO_PRICE = 1000;
	private static final int LOTTO_NUMBER_MINIMUM = 1;
	private static final int LOTTO_NUMBER_MAXIMUM = 45;
	private static final int LOTTO_NUMBER_SIZE = 6;
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

}
