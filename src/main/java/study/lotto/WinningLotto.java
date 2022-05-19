package study.lotto;

import study.lotto.enumtype.LottoWinningType;

public class WinningLotto {
    private static final int LOTTO_BONUS_MATCH_COUNT = 5;
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoWinningType matchLotto(Lotto lotto) {
        int matchCount = matchCount(lotto);
        boolean bonusMatch = matchBonus(lotto);

        if (matchCount == LOTTO_BONUS_MATCH_COUNT && bonusMatch) {
            return LottoWinningType.SECOND;
        }
        if (matchCount == LOTTO_BONUS_MATCH_COUNT) {
            return LottoWinningType.THIRD;
        }

        return LottoWinningType.valueOf(matchCount);
    }

    private void validate(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private int matchCount(Lotto lotto) {
        return (int) winningNumber.getNumbers().stream()
                .filter(num -> lotto.getNumbers().contains(num))
                .count();
    }

    private boolean matchBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
