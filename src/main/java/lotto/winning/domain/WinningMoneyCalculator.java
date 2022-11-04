package lotto.winning.domain;

import static lotto.winning.domain.WinningMoney.*;

public class WinningMoneyCalculator {

    private final int matchCount;
    private final int lottoCount;

    public WinningMoneyCalculator(int matchCount, int lottoCount) {
        this.matchCount = matchCount;
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long calculate() {
        return find(this.matchCount).getMoney() * lottoCount;
    }
}
