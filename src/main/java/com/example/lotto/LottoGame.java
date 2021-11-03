package com.example.lotto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
	public static final int PRICE = 1000;

	private static final int LOTTO_NUMBER_COUNT = 6;

	private final List<LottoNumber> lottoNumbers;

	public LottoGame(List<LottoNumber> lottoNumbers) {
		throwOnInvalidLottoNumberCount(lottoNumbers);
		throwOnDuplicatedLottoNumber(lottoNumbers);

		this.lottoNumbers = lottoNumbers.stream()
			.sorted(Comparator.comparingInt(LottoNumber::getValue))
			.collect(Collectors.toList());
	}

	private void throwOnInvalidLottoNumberCount(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자의 갯수는 6개여야 합니다.");
		}
	}

	private void throwOnDuplicatedLottoNumber(List<LottoNumber> lottoNumbers) {
		if (new HashSet<>(lottoNumbers).size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자는 중복되지 않아야 합니다.");
		}
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}
}
