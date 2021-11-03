package com.example.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
	private static final List<Integer> CANDIDATES;

	static {
		CANDIDATES = new ArrayList<>();

		for (int number = LottoNumber.ONE; number <= LottoNumber.FORTY_FIVE; number++) {
			CANDIDATES.add(number);
		}
	}

	@Override
	public List<Integer> generate() {
		Collections.shuffle(CANDIDATES);
		return CANDIDATES.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT);
	}
}
