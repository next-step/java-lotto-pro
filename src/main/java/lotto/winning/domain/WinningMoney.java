package lotto.winning.domain;

import common.vo.Count;

import static lotto.winning.domain.WinningMoneyType.*;

public class WinningMoney {

    private final Count matchCount;
    private final Count lottoCount;

    public WinningMoney(Count matchCount, Count lottoCount) {
        this.matchCount = matchCount;
        this.lottoCount = lottoCount;
    }

    public long calculate() {
        return find(this.matchCount.getNumber()).getMoney() * lottoCount.getNumber();
    }
}
