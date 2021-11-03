package com.example.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumbersGenerator implements LottoNumbersGenerator {
	private static final List<LottoNumber> CANDIDATES;

	static {
		CANDIDATES = new ArrayList<>();

		for (int number = LottoNumber.ONE; number <= LottoNumber.FORTY_FIVE; number++) {
			CANDIDATES.add(new LottoNumber(number));
		}
	}

	@Override
	public List<LottoNumber> generate() {
		Collections.shuffle(CANDIDATES);
		return CANDIDATES.subList(0, LottoGame.LOTTO_NUMBER_COUNT);
	}
}
