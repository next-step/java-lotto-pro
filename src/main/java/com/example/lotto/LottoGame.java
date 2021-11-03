package com.example.lotto;

public class LottoGame {
	public static final int LOTTO_GAME_PRICE = 1000;

	private final LottoNumbers lottoNumbers;

	public LottoGame(NumbersGenerator numbersGenerator) {
		this.lottoNumbers = new LottoNumbers(numbersGenerator.generate());
	}

	public LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}
}
