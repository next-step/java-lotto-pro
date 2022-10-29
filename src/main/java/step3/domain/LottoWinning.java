package step3.domain;

public class LottoWinning {
    private final Lotto winningLotto;
    private final int bonusNumber;

    private LottoWinning(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning of(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        return new LottoWinning(winningLotto, bonusNumber);
    }

    private static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (!LottoNumberValidator.isLottoNumberRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1-45사이의 숫자를 충족해야 합니다.");
        }
        if (winningLotto.containsBy(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 기존의 로또번호와 중복이 될 수 없습니다");
        }
    }

    public long getLottoMatchCount(Lotto lotto) {
        return lotto.getNumberCountContainsBy(winningLotto);
    }

    public boolean matchBonusNumberBy(Lotto lotto) {
        return lotto.containsBy(bonusNumber);
    }
}
