package step3.domain;

public class WinningLottoNumber {
    private static final String BONUS_NUMBER_CAN_NOT_INCLUDED_IN_WINNING_NUMBERS = "당첨번호와 보너스 번호는 중복될 수 없습니다.";
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumber(final String receiveWinningNumber, final int receiveBonusNumber) {
        this.winningLottoNumbers = new LottoNumbers(receiveWinningNumber);
        this.bonusNumber = new LottoNumber(receiveBonusNumber);
        validateBonusNumberIncludedInWinningNumbers();
    }

    private void validateBonusNumberIncludedInWinningNumbers() {
        if (this.winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_CAN_NOT_INCLUDED_IN_WINNING_NUMBERS);
        }
    }

    public Rewards check(final Lottos lottos) {
        return lottos.check(winningLottoNumbers, bonusNumber);
    }
}
