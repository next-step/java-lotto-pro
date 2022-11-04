package lotto.winning.domain;

import common.vo.Count;
import lotto.lotto.domain.Lotto;

import java.util.List;

public class MatchingCount {

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;

    public MatchingCount(List<Lotto> lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public Count lottoCount(int matchingCount) {
        int lottoCount = 0;
        for (Lotto lotto : this.lottos) {
            lottoCount = lottoCountUp(matchingCount, lottoCount, lotto);
        }
        return new Count(lottoCount);
    }

    private int lottoCountUp(int matchingCount, int lottoCount, Lotto lotto) {
        if (isSame(matchingCount, lotto)) {
            lottoCount++;
        }
        return lottoCount;
    }

    private boolean isSame(int matchingCount, Lotto lotto) {
        return this.winningNumber.findMatchingCount(lotto) == matchingCount;
    }
}
