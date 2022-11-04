package lotto.winning.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalWinningMoneyFixture {
    public static TotalWinningMoney 당첨금액_5000() {
        List<WinningMoney> winningMoneyList = new ArrayList<>();
        winningMoneyList.add(new WinningMoney(3, 1));
        return new TotalWinningMoney(winningMoneyList);
    }
}
