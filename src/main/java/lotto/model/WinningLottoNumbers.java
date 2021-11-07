package lotto.model;

public class WinningLottoNumbers {
	private static final int COUNT_VALUE = 1;
	private static final int NOT_COUNT_VALUE = 0;

	private final LottoNumbers winninglottoNumbers;
	private LottoNumber bonusNumber;

	public WinningLottoNumbers(String inputWinninglottoNumber) {
		this.winninglottoNumbers = new LottoNumbers(inputWinninglottoNumber);
	}

	public WinningLottoNumbers(String inputWinninglottoNumber, String inputBonusNumber) {
		this.winninglottoNumbers = new LottoNumbers(inputWinninglottoNumber);
		this.bonusNumber = new LottoNumber(Integer.parseInt(inputBonusNumber));
	}

	public int size() {
		return winninglottoNumbers.size();
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return winninglottoNumbers.containsLottoNumber(lottoNumber);
	}

	public int containsCountLottoNumber(LottoNumber lottoNumber) {
		if (containsLottoNumber(lottoNumber)) {
			return COUNT_VALUE;
		}
		return NOT_COUNT_VALUE;
	}
}
