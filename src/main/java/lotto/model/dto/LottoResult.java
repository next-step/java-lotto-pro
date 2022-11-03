package lotto.model.dto;

import lotto.model.vo.Profit;
import lotto.model.vo.WinResult;

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
