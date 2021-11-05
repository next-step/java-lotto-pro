package com.example.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static final int LOTTO_NUMBER_COUNT = 6;

	private final List<LottoNumber> values;

	private LottoNumbers(List<LottoNumber> numbers) {
		this.values = numbers;
	}

	static LottoNumbers of(List<Integer> numbers) {
		throwOnInvalidLottoNumberCount(numbers);
		throwOnDuplicatedLottoNumber(numbers);

		return new LottoNumbers(
			numbers.stream()
				.sorted()
				.map(LottoNumber::of)
				.collect(Collectors.toList())
		);
	}

	public static int match(LottoNumbers first, LottoNumbers second) {
		Set<LottoNumber> intersection = first.values.stream()
			.filter(second.values::contains)
			.collect(Collectors.toSet());

		return intersection.size();
	}

	private static void throwOnInvalidLottoNumberCount(List<Integer> numbers) {
		if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자의 갯수는 6개여야 합니다.");
		}
	}

	private static void throwOnDuplicatedLottoNumber(List<Integer> numbers) {
		if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 숫자는 중복되지 않아야 합니다.");
		}
	}

	public List<LottoNumber> getValues() {
		return values;
	}

	@Override
	public String toString() {
		List<String> elements = values.stream()
			.map(LottoNumber::getValue)
			.map(String::valueOf)
			.collect(Collectors.toList());

		return String.join(", ", elements);
	}

	public boolean contains(LottoNumber lottoNumber) {
		return values.contains(lottoNumber);
	}
}
