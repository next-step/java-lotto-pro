package step3.domain.lotto;

import static step3.type.ErrorMessageType.LOTTO_NUMBER_DUPLICATE;

public class WinningLotto {

    private final WinningLottoNumbers winningLottoNumbers;
    private final BonusLottoNumber bonusLottoNumber;

    public WinningLotto(WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        validateBonusLottoNumber(winningLottoNumbers, bonusLottoNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validateBonusLottoNumber(WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        if (isContainBonusLottoNumber(winningLottoNumbers, bonusLottoNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private boolean isContainBonusLottoNumber(WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        return winningLottoNumbers.value().contains(bonusLottoNumber.value());
    }

    public WinningLottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public BonusLottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
