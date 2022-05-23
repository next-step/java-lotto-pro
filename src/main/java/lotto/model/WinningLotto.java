package lotto.model;

public class WinningLotto {
	private final LottoNumbers lottoNumbers;
	private final String bonusLottoNumber;
	
	public WinningLotto(LottoNumbers lottoNumbers, String bonusLottoNumber) {
		validationBonus(lottoNumbers, bonusLottoNumber);
		this.lottoNumbers = lottoNumbers;
		this.bonusLottoNumber = bonusLottoNumber;
	}
	
	private void validationBonus(LottoNumbers lastWinningLotto, String bonusLottoNumber) {
		if (lastWinningLotto.contains(new LottoNumber(bonusLottoNumber))) {
			throw new IllegalArgumentException("입력된 보너스볼 숫자가 이미 로또번호에 포함되어 있습니다.");
		}
	}
	
	public LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}
	
	public String getBonusLottoNumber() {
		return bonusLottoNumber;
	}
}
