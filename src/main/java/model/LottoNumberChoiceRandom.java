package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberChoiceRandom implements LottoNumberChoiceStrategy {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int NUMBERS_COUNT = 6;

	@Override
	public LottoNumbers choose() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = MIN_NUMBER; i <= MAX_NUMBER; ++i) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return new LottoNumbers(
			numbers.subList(0, NUMBERS_COUNT)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList())
		);
	}
}
