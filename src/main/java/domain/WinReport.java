package domain;

import java.util.HashMap;
import java.util.Map;

public class WinReport {
    private static final int LOTTE_PRICE = 1000;
    private static final int WIN_MIN_NUMBER = 3;
    private static final int WIN_MAX_NUMBER = 6;

    private final Map<Integer, Integer> result = new HashMap<>();

    public void putLottoResult(int collectNumber) {
        result.put(collectNumber, getLottoResult(collectNumber) + 1);
    }

    public int getLottoResult(int collectNumber) {
        return result.getOrDefault(collectNumber, 0);
    }

    public double calculateProfit(int lottoTicketCount, boolean matchBonus) {
        double profit = 0;
        for (int i = WIN_MIN_NUMBER; i < WIN_MAX_NUMBER; i++) {
            profit += getLottoResult(i) * PrizeMoney.valueOf(i, matchBonus).prizeMoney();
        }
        return Math.floor(profit / (lottoTicketCount * LOTTE_PRICE) * 100) / 100;
    }

}
