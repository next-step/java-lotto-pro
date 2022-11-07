package lotto.model.dto;

import lotto.model.domain.Profit;
import lotto.model.domain.WinResult;

public class LottoResult {

    private WinResult winResult;
    private Profit profit;

    public LottoResult(WinResult winResult, Profit profit) {
        this.winResult = winResult;
        this.profit = profit;
    }

    public WinResult getWinResult() {
        return winResult;
    }

    public Profit getProfit() {
        return profit;
    }
}
