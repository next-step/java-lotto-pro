package study.lotto;

import java.util.HashSet;
import java.util.Set;
import study.lotto.enumtype.LottoWinningType;

public class WinningLotto {
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

        if (matchCount == 5 && bonusMatch) {
            return LottoWinningType.SECOND;
        }
        if (matchCount == 5) {
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
        Set<Integer> lottoSet = new HashSet<>();
        lottoSet.addAll(lotto.getNumbers());
        lottoSet.addAll(this.winningNumber.getNumbers());
        return lotto.numberSize() * 2 - lottoSet.size();
    }

    private boolean matchBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
