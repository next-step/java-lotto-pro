package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberChoiceRandom implements LottoNumberChoiceStrategy {
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int NUMBERS_COUNT = 6;

	@Override
	public List<Integer> choose() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; ++i) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers.subList(0, NUMBERS_COUNT);
	}
}
