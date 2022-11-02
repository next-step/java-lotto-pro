package lotto.domain;

import lotto.view.Error;
import lotto.view.OutputView;

import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> insertWinningLotto, LottoNumber bonusBall) {
        super(insertWinningLotto);

        if (!isValid(insertWinningLotto, bonusBall)) {
            throw new IllegalArgumentException(Error.BONUS_BALL_DUPLICATE);
        }
        this.bonusBall = bonusBall;
    }

    public static boolean isValid(List<LottoNumber> insertWinningLotto, LottoNumber bonusBall) {
        if (!Lotto.isValid(insertWinningLotto)) {
            return false;
        }
        if (insertWinningLotto.stream()
                .anyMatch(number -> number.equals(bonusBall))) {
            OutputView.print(Error.BONUS_BALL_DUPLICATE);
            return false;
        }
        return true;
    }

    public Rank getRank(Lotto lotto) {
        return Rank.valueOf(getCorrectCount(lotto), lotto.hasBonusBall(bonusBall));
    }
}
