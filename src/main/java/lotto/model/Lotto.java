package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
	private static final List<LottoNumber> LOTTO_NUMBER_CANDIDATE;

	private final LottoNumbers numbers;

	static {
		LOTTO_NUMBER_CANDIDATE = new ArrayList<>();
		for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
			LOTTO_NUMBER_CANDIDATE.add(new LottoNumber(i));
		}
	}

	public Lotto() {
		numbers = new LottoNumbers(makeNonDuplicateLottoNumbers());
	}
	public Lotto(LottoNumbers numbers) {
		this.numbers = numbers;
	}


	public static List<LottoNumber> makeNonDuplicateLottoNumbers() {
		List<LottoNumber> suffledLottoNumbers = new ArrayList<>(LOTTO_NUMBER_CANDIDATE);
		Collections.shuffle(suffledLottoNumbers);
		return suffledLottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
