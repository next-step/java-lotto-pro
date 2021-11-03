package com.example.lotto;

import java.util.List;

public class LottoGame {
	public static final int LOTTO_GAME_PRICE = 1000;

	private final LottoNumbers lottoNumbers;

	public LottoGame(NumbersGenerator numbersGenerator) {
		List<Integer> numbers = numbersGenerator.generate(
			LottoNumber.ONE,
			LottoNumber.FORTY_FIVE,
			LottoNumbers.LOTTO_NUMBER_COUNT);

		this.lottoNumbers = new LottoNumbers(numbers);
	}

	public LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}
}
