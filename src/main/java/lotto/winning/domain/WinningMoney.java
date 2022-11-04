package lotto.winning.domain;

import static lotto.winning.domain.WinningMoneyType.*;

public class WinningMoney {

    private final int matchCount;
    private final int lottoCount;

    public WinningMoney(int matchCount, int lottoCount) {
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
