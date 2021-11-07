package lotto.model;

public class WinningLottoNumbers {
	private static final int COUNT_VALUE = 1;
	private static final int NOT_COUNT_VALUE = 0;

	private final LottoNumbers winningLottoNumbers;
	private LottoNumber bonusNumber;

	public WinningLottoNumbers(String inputWinningLottoNumber) {
		this.winningLottoNumbers = new LottoNumbers(inputWinningLottoNumber);
	}

	public WinningLottoNumbers(String inputWinningLottoNumber, String inputBonusNumber) {
		this.winningLottoNumbers = new LottoNumbers(inputWinningLottoNumber);
		this.bonusNumber = new LottoNumber(Integer.parseInt(inputBonusNumber));
	}

	public int size() {
		return winningLottoNumbers.size();
	}

	public boolean containsLottoNumber(LottoNumber lottoNumber) {
		return winningLottoNumbers.containsLottoNumber(lottoNumber);
	}

	public int containsCountLottoNumber(LottoNumber lottoNumber) {
		if (containsLottoNumber(lottoNumber)) {
			return COUNT_VALUE;
		}
		return NOT_COUNT_VALUE;
	}
}
