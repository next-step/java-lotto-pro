package com.example.lotto;

import java.util.List;

public class LottoGame {
	public static final int LOTTO_GAME_PRICE = 1000;

	private final LottoNumbers lottoNumbers;

	private LottoGame(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	static LottoGame manual(List<Integer> numbers) {
		return new LottoGame(LottoNumbers.of(numbers));
	}

	static LottoGame auto(NumbersGenerator numbersGenerator) {
		List<Integer> numbers = numbersGenerator.generate(
			LottoNumber.ONE,
			LottoNumber.FORTY_FIVE,
			LottoNumbers.LOTTO_NUMBER_COUNT);

		return new LottoGame(LottoNumbers.of(numbers));
	}

	public LottoRank rank(WinningLottoNumbers winningLottoNumbers) {
		int countOfMatch = LottoNumbers.match(lottoNumbers, winningLottoNumbers.getBaseNumbers());
		boolean matchBonus = lottoNumbers.contains(winningLottoNumbers.getBonusNumber());

		return LottoRank.valueOf(countOfMatch, matchBonus);
	}

	public LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}

	@Override
	public String toString() {
		return String.format("[%s]", lottoNumbers.toString());
	}
}
