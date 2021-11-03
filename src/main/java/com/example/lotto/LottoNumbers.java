package com.example.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final int LOTTO_NUMBER_COUNT = 6;

	private final List<LottoNumber> values;

	public LottoNumbers(List<Integer> numbers) {
		throwOnInvalidLottoNumberCount(numbers);
		throwOnDuplicatedLottoNumber(numbers);

		this.values = numbers.stream()
			.sorted()
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private void throwOnInvalidLottoNumberCount(List<Integer> numbers) {
		if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자의 갯수는 6개여야 합니다.");
		}
	}

	private void throwOnDuplicatedLottoNumber(List<Integer> numbers) {
		if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자는 중복되지 않아야 합니다.");
		}
	}

	public List<LottoNumber> getValues() {
		return values;
	}
}
