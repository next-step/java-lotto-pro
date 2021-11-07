package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
	private static final List<LottoNumber> LOTTO_NUMBER_CANDIDATE;

	protected final LottoNumbers numbers;

	static {
		LOTTO_NUMBER_CANDIDATE = new ArrayList<>();
		for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
			LOTTO_NUMBER_CANDIDATE.add(new LottoNumber(i));
		}
	}

	public Lotto() {
		numbers = makeNonDuplicateLottoNumbers();
	}
	public Lotto(LottoNumbers numbers) {
		this.numbers = numbers;
	}

	/**
	 * 중복되지 않은 LottoNumber를 가진 LottoNumbers 객체
	 * @return LottoNumbers
	 */
	public static LottoNumbers makeNonDuplicateLottoNumbers() {
		List<LottoNumber> suffledLottoNumbers = new ArrayList<>(LOTTO_NUMBER_CANDIDATE);
		Collections.shuffle(suffledLottoNumbers);
		return new LottoNumbers(suffledLottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT));
	}

	/**
	 * 로또에 입력받은 로또 번호가 존재하는지 여부
	 * @param lottoNumber 로또 번호
	 * @return 존재 여부
	 */
	public boolean contains(LottoNumber lottoNumber) {
		return numbers.contains(lottoNumber);
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
		Lotto lotto = (Lotto)o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
