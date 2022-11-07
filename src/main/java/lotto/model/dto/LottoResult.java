package lotto.model.dto;

import lotto.model.domain.Profit;
import lotto.model.domain.WinResult;

public class LottoResult {

    private WinResult winResult;
    private Profit profit;

    public WinResult getWinResult() {
        return winResult;
    }

    public Profit getProfit() {
        return profit;
    }

    public void setWinResult(WinResult winResult) {
        this.winResult = winResult;
    }

    public void setProfit(Profit profit) {
        this.profit = profit;
    }
}
