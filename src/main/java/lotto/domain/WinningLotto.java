package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private final Lotto winningLotto;

    private final LottoNumber bonusBall;

    private static final int WINNING_AND_BOUNS_COUNT = 7;

    private static final int WINNING_BOUNS_COUNT = 5;

    private static final String WINNING_AND_BOUNS_NOT_SAME = "당첨 번호와 보너스 번호는 중복이 불가합니다.";

    private WinningLotto(final Lotto winningLotto, final LottoNumber bonusBall) {
        validate(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto from(final Lotto winningLotto, final LottoNumber bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    public LottoRank winningMatch(final Lotto lotto) {
        int matchCount = lotto.matchLottoNumber(this.winningLotto);

        if (matchCount == WINNING_BOUNS_COUNT) {
            return LottoRank.valueOf(matchCount, lotto.matchBounsNumber(this.bonusBall));
        }

        return LottoRank.valueOf(matchCount, false);
    }

    private void validate(final Lotto winningLotto, final LottoNumber bonusBall) {
        validateDuplicate(winningLotto, bonusBall);
    }

    private void validateDuplicate(final Lotto winningLotto, final LottoNumber bonusBall) {
        Set<LottoNumber> numberSet = new HashSet<>(winningLotto.getLottoNumbers());
        numberSet.add(bonusBall);

        if (numberSet.size() != WINNING_AND_BOUNS_COUNT) {
            throw new IllegalArgumentException(WINNING_AND_BOUNS_NOT_SAME);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
