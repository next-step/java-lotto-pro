package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

	private final List<LottoNumber> lottoNumbers;

	private LottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public static LottoNumbers of(int... numbers) {
		return new LottoNumbers(
			Arrays.stream(numbers)
				.mapToObj(LottoNumber::of)
				.collect(Collectors.toList()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoNumbers that = (LottoNumbers)o;
		return lottoNumbers.equals(that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return "LottoNumbers{" +
			"lottoNumbers=" + lottoNumbers +
			'}';
	}
}
