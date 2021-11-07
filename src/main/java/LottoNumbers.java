import java.util.Arrays;

public class LottoNumbers {
	public static final String MESSAGE_NOT_ALLOW_LENGTH = "LOTTO_NUMBERS_LENGTH_MUST_BE_6";
	public static final String MESSAGE_NOT_ALLOW_DUPLICATION = "LOTTO_NUMBERS_ELEMENT_MUST_BE_INDEPENDENT";
	public static final int LOTTO_NUMBERS_LENGTH = 6;

	private final LottoNumber[] lottoNumbers;

	public LottoNumbers(LottoNumber[] lottoNumbers) {
		if (lottoNumbers.length != LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_LENGTH);
		}

		this.lottoNumbers = new LottoNumber[lottoNumbers.length];
		for (int i = 0; i < lottoNumbers.length; ++i) {
			validateDuplication(lottoNumbers, i);
			this.lottoNumbers[i] = lottoNumbers[i];
		}
	}

	private void validateDuplication(LottoNumber[] lottoNumbers, int i) {
		for (int j = i + 1; j < lottoNumbers.length; ++j) {
			validateDuplication(lottoNumbers, i, j);
		}
	}

	private void validateDuplication(LottoNumber[] lottoNumbers, int i, int j) {
		if (lottoNumbers[i].equals(lottoNumbers[j])) {
			throw new IllegalArgumentException(MESSAGE_NOT_ALLOW_DUPLICATION);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Arrays.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(lottoNumbers);
	}
}
