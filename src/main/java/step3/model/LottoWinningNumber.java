package step3.model;

/**
 * 로또 당첨 번호
 */
public class LottoWinningNumber {
    private final LottoNumber winningNumbers;
    private int bonusNumber;

    public LottoWinningNumber(LottoNumber winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoWinningNumber(LottoNumber winningNumbers, int bonusNumber) {
        this(winningNumbers);
        this.bonusNumber = bonusNumber;
        validateUniqueBonus(winningNumbers, bonusNumber);
    }

    private void validateUniqueBonus(LottoNumber winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException("번호가 동일한게 존재합니다.");
        }
    }

    public int getMatchedCount(LottoNumber lottoNumber) {
        return winningNumbers.getMatchedCount(lottoNumber);
    }

    public boolean isMatchedBonus(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}
