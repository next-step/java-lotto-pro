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
	public static final int LOTTO_NUMBER_COUNT = 6;

	protected final List<LottoNumber> numbers;

	public LottoNumbers(int...arrayIntNumbers) {
		this(convertIntegerArrayToLottoNumberList(arrayIntNumbers));
	}
	public LottoNumbers(List<LottoNumber> numbers) {
		validateNumbers(numbers);
		List<LottoNumber> sorted = new ArrayList<>(numbers);
		Collections.sort(sorted);
		this.numbers = sorted;
	}
	public LottoNumbers(String numbers) {
		this(convertStringNumbersToIntArray(numbers));
	}

	/**
	 * 콤마로 구분된 번호 문자열값을 정수 배열로 변환
	 * @param nubmers 콤마로 구분된 번호 문자열
	 * @return 정수 배열
	 */
	public static int[] convertStringNumbersToIntArray(String nubmers) {
		return Arrays.stream(nubmers.split(","))
			.map(String::trim)
			.mapToInt(Integer::parseInt).toArray();
	}

	/**
	 * int 배열을 LottoNumber리스트로 변환
	 * @param intNumbers int 배열
	 * @return LottoNumber 리스트
	 */
	public static List<LottoNumber> convertIntegerArrayToLottoNumberList(int[] intNumbers) {
		return Arrays.stream(intNumbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
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

	/**
	 * 로또 번호가 포함되어있는지 여부
	 * @param lottoNumber 로또 번호
	 * @return 포함되어있는지 여부
	 */
	public boolean contains(LottoNumber lottoNumber) {
		return numbers.contains((lottoNumber));
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
