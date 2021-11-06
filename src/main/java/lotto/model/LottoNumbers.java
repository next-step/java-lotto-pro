package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private final List<LottoNumber> numbers;

	public LottoNumbers() {
		this(makeNonDuplicateLottoNumbers());
	}

	public LottoNumbers(List<LottoNumber> numbers) {
		validateNumbers(numbers);
		List<LottoNumber> sorted = new ArrayList<>(numbers);
		Collections.sort(sorted);
		this.numbers = sorted;
	}

	/**
	 * 로또 번호 유효성 체크
	 * @param numbers 로또 번호 목록
	 */
	private void validateNumbers(List<LottoNumber> numbers) {
		if (numbers == null || numbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("로또 번호가 없거나 크기가 다릅니다 : "+numbers);
		}
		Map<String, Boolean> duplicationCheck = new HashMap<>();
		numbers.forEach(no -> duplicationCheck.put(no.toString(), true));
		if (duplicationCheck.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("중복된 로또 번호가 존재합니다. : "+numbers);
		}

	}

	public static List<LottoNumber> makeNonDuplicateLottoNumbers() {
		Set<LottoNumber> generatedLottoNumberSet = new HashSet<>();
		while(generatedLottoNumberSet.size() != LOTTO_NUMBER_COUNT) {
			LottoNumber no = makeLottoNumber();
			generatedLottoNumberSet.add(no);
		}
		return new ArrayList<>(generatedLottoNumberSet);
	}

	/**
	 * 로또 번호 생성
	 * @return 최소값(1) ~ 최대값(45) 사이의 정수
	 */
	public static LottoNumber makeLottoNumber() {
		return new LottoNumber((int)(Math.random() * MAX_LOTTO_NUMBER + MIN_LOTTO_NUMBER));
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers numbers1 = (LottoNumbers)o;
		return Objects.equals(numbers, numbers1.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
