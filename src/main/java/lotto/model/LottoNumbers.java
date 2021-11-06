package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final List<LottoNumber> LOTTO_NUMBER_CANDIDATE;

	private final List<LottoNumber> numbers;

	static {
		LOTTO_NUMBER_CANDIDATE = new ArrayList<>();
		for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
			LOTTO_NUMBER_CANDIDATE.add(new LottoNumber(i));
		}
	}

	public LottoNumbers() {
		this(makeNonDuplicateLottoNumbers());
	}

	public LottoNumbers(int...arrayIntNumbers) {
		this(convertIntegerArrayToLottoNumberList(arrayIntNumbers));
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
		Set<LottoNumber> duplicationCheck = new HashSet<>(numbers);
		if (duplicationCheck.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException("중복된 로또 번호가 존재합니다. : "+numbers);
		}

	}

	public static List<LottoNumber> convertIntegerArrayToLottoNumberList(int[] intNumbers) {
		return Arrays.stream(intNumbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
	}

	public static List<LottoNumber> makeNonDuplicateLottoNumbers() {
		List<LottoNumber> suffledLottoNumbers = new ArrayList<>(LOTTO_NUMBER_CANDIDATE);
		Collections.shuffle(suffledLottoNumbers);
		return suffledLottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
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
