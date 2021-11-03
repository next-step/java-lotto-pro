package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDomain {

	private static final int LOTTO_PRICE = 1000;

	public int getLottoCountByMoney(int money) {
		return money / LOTTO_PRICE;
	}

	public List<List<Integer>> getLottoNumbersByCount(int count) {
		List<List<Integer>> numberList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			List<Integer> numbers = new ArrayList<>();
			numberList.add(numbers);
		}
		return numberList;
	}

	public List<Integer> generateLottoNumber() {
		List<Integer> candidates = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			candidates.add(i);
		}
		Collections.shuffle(candidates);

		List<Integer> numbers = new ArrayList<>(candidates.subList(0, 6));
		Collections.sort(numbers);
		return numbers;
	}
}
