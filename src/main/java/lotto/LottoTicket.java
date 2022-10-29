package lotto;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

	public static final int NUMBER_COUNT = 6;

	private final List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> lottoNumbers) {
		verifyIsValidNumbers(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoTicket of(int... numbers) {
		return of(Arrays.stream(numbers)
			.boxed()
			.collect(Collectors.toList()));
	}

	public static LottoTicket of(List<Integer> numbers) {
		return new LottoTicket(
			numbers.stream()
				.map(LottoNumber::of)
				.collect(Collectors.toList()));
	}

	private void verifyIsValidNumbers(List<LottoNumber> lottoNumbers) {
		if (isNumberCountValid(lottoNumbers)) {
			throw new IllegalArgumentException(format("한 장의 로또 번호 숫자 갯수는 %s개 여야 합니다.", NUMBER_COUNT));
		}
		if (isNumberNotUnique(lottoNumbers)) {
			throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
		}
	}

	private boolean isNumberNotUnique(List<LottoNumber> lottoNumbers) {
		return isNumberCountEqual(lottoNumbers.stream().distinct().count());
	}

	private boolean isNumberCountValid(List<LottoNumber> lottoNumbers) {
		return isNumberCountEqual(lottoNumbers.size());
	}

	private boolean isNumberCountEqual(long count) {
		return count != NUMBER_COUNT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoTicket that = (LottoTicket)o;
		return lottoNumbers.equals(that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return lottoNumbers.stream()
			.map(LottoNumber::toString)
			.collect(joining(", ", "[", "]"));
	}

	public int match(LottoTicket other) {

		Set<LottoNumber> comparedLottoNumbers = new HashSet<>(other.lottoNumbers);

		int equalNumberCount = 0;
		for (LottoNumber lottoNumber : this.lottoNumbers) {
			equalNumberCount += comparedLottoNumbers.contains(lottoNumber) ? 1 : 0;
		}

		return equalNumberCount;
	}

}
