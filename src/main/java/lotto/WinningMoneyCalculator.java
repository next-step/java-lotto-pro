package lotto;

import static lotto.WinningMoney.*;

public class WinningMoneyCalculator {

    private final int matchCount;
    private final int lottoCount;

    public WinningMoneyCalculator(int matchCount, int lottoCount) {
        this.matchCount = matchCount;
        this.lottoCount = lottoCount;
    }

    public long calculate() {
        return find(this.matchCount).getMoney() * lottoCount;
    }
}
