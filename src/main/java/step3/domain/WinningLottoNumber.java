package step3.domain;

public class WinningLottoNumber {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumber(final String receiveWinningNumber, final int receiveBonusNumber) {
        this.winningLottoNumbers = new LottoNumbers(receiveWinningNumber);
        this.bonusNumber = new LottoNumber(receiveBonusNumber);
        validateBonusNumberIncludedInWinningNumbers();
    }

    private void validateBonusNumberIncludedInWinningNumbers() {
        if (this.winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public Rewards check(final Lottos lottos) {
        return lottos.check(winningLottoNumbers, bonusNumber);
    }
}
