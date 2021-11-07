import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
	public static final String MESSAGE_NOT_ALLOW_LENGTH = "LOTTO_NUMBERS_LENGTH_MUST_BE_6";
	public static final int LOTTO_NUMBERS_LENGTH = 6;

	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_LENGTH);
		}

		this.lottoNumbers = new ArrayList<>();
		sortLottoNumbers(lottoNumbers);
		this.lottoNumbers.addAll(lottoNumbers);
	}

	private void sortLottoNumbers(List<LottoNumber> lottoNumbers) {
		lottoNumbers.sort(LottoNumber::getComparatorOther);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}
}
