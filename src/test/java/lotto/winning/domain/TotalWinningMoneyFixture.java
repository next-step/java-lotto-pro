package lotto.winning.domain;

import common.vo.Count;

public class TotalWinningMoneyFixture {
    public static TotalWinningMoney 당첨금액_5000() {
        return new TotalWinningMoney(new Count(1), new Count(0), new Count(0), new Count(0));
    }
}
