package lotto.winning.domain;

import common.vo.Count;
import lotto.lotto.domain.Lotto;

import java.util.List;

public class MatchCount {

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;

    public MatchCount(List<Lotto> lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public Count matchCount(int number) {
        int count = 0;
        for (Lotto lotto : this.lottos) {
            count = matchCountUp(number, count, lotto);
        }
        return new Count(count);
    }

    private int matchCountUp(int number, int count, Lotto lotto) {
        if (isMatch(number, lotto)) {
            count++;
        }
        return count;
    }

    private boolean isMatch(int number, Lotto lotto) {
        return this.winningNumber.matchCounts(lotto) == number;
    }
}
