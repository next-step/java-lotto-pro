package step5.model;

/**
 * 로또 당첨 번호
 */
public class LottoWinningNos {
    private final Lotto winningNumbers;
    private LottoNo bonusNumber;

    public LottoWinningNos(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoWinningNos(Lotto winningNumbers, LottoNo bonusNumber) {
        this(winningNumbers);
        this.bonusNumber = bonusNumber;
        validateUniqueBonus(winningNumbers, bonusNumber);
    }

    private void validateUniqueBonus(Lotto winningNumbers, LottoNo bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new RuntimeException("번호가 동일한게 존재합니다.");
        }
    }

    public int getMatchedCount(Lotto lotto) {
        return lotto.getMatchedCount(winningNumbers);
    }

    public boolean isMatchedBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
