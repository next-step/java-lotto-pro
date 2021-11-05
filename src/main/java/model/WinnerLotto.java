package model;

public final class WinnerLotto implements Lotto {

	private final LottoNumbers lottoNumbers;

	private final LottoNumber bonusNumber;

	private WinnerLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		validateNull(lottoNumbers, "'lottoNumbers' must not be null");
		validateNull(bonusNumber, "'bonusNumber' must not be null");
		validateDuplication(lottoNumbers, bonusNumber);
		this.lottoNumbers = lottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	static WinnerLotto from(LottoNumbers numbers, LottoNumber bonusNumber) {
		return new WinnerLotto(numbers, bonusNumber);
	}

	public LottoNumbers numbers() {
		return lottoNumbers;
	}

	public LottoNumber bonus() {
		return bonusNumber;
	}

	@Override
	public String toString() {
		return "WinnerLotto{" +
			"lottoNumbers=" + lottoNumbers +
			", bonusNumber=" + bonusNumber +
			'}';
	}

	private void validateDuplication(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		if (lottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(
				String.format("lottoNumbers(%s) must not have bonusNumber(%s)", lottoNumbers, bonusNumber));
		}
	}

	private void validateNull(Object target, String message) {
		if (target == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
