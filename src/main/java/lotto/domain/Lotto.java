package lotto.domain;

import java.util.List;

public class Lotto {
	public static final int LOTTO_SIZE = 6;

	private final String INVALID_SIZE = "로또 번호는 6개를 입력해야 합니다.";

	private Numbers numbers;

	public Lotto(List<Number> numbers) {
		validSize(numbers);
		this.numbers = new Numbers(numbers);
	}

	private void validSize(List<Number> numbers) {
		if(numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(INVALID_SIZE);
		}
	}
}
