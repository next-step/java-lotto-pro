package lotto.model;

public class WinningLottoNumber {
    private final LottoNumber lottoNumber;
    private final Number bonusNumber;

    public WinningLottoNumber(LottoNumber lottoNumber, Number bonusNumber) {
        validateDuplicateBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoNumber lottoNumber, Number bonusNumber) {
        if (lottoNumber.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }
}
