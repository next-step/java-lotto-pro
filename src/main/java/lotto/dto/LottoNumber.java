package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Number;

public class LottoNumber {
	private List<Integer> numbers;

	public LottoNumber(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static LottoNumber convertTo(List<Number> numbers) {
		return new LottoNumber(numbers.stream()
						.map(Number::getNumber)
						.collect(Collectors.toList()));
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
