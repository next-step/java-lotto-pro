package domain;

import java.util.HashMap;
import java.util.Map;

public class WinReport {
    private static final int LOTTE_PRICE = 1000;

    private final Map<PrizeMoney, Integer> result = new HashMap<>();

    public void putLottoResult(PrizeMoney collectNumber) {
        result.put(collectNumber, getLottoResult(collectNumber) + 1);
    }

    public int getLottoResult(PrizeMoney collectNumber) {
        return result.getOrDefault(collectNumber, 0);
    }

    public double calculateProfit(int lottoTicketCount) {
        double profit = 0;

        for (PrizeMoney prizeMoney : result.keySet()) {
            profit += prizeMoney.getPrizeMoney() * getLottoResult(prizeMoney);
        }

        return Math.floor(profit / (lottoTicketCount * LOTTE_PRICE) * 100) / 100;
    }

}
