package lotto.domain;

import lotto.view.Error;

import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> insertWinningLotto, LottoNumber bonusBall) {
        super(insertWinningLotto);

        validate(insertWinningLotto, bonusBall);
        this.bonusBall = bonusBall;
    }

    public static void validate(List<LottoNumber> insertWinningLotto, LottoNumber bonusBall) {
        Lotto.validate(insertWinningLotto);
        if (insertWinningLotto.stream()
                .anyMatch(number -> number.equals(bonusBall))) {
            throw new IllegalArgumentException(Error.BONUS_BALL_DUPLICATE);
        }
    }

    public Rank getRank(Lotto lotto) {
        return Rank.valueOf(getCorrectCount(lotto), lotto.hasBonusBall(bonusBall));
    }
}
